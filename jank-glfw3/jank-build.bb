;; Demo of a "build script" which invokes pkg-config to find a system
;; dependency.

(require '[clojure.string :as string]
         '[babashka.process :as proc])

(defn pkg-config [pc-name var]
  (-> (proc/sh ["pkg-config" pc-name "--variable" var])
      proc/check
      :out
      string/trim-newline))

(binding [*out* *err*]
  (println "This is what stderr looks like"))

(let [pc-name "glfw3"]
  (println (str "jank-build::include-dir=" (pkg-config pc-name "includedir")))
  (println (str "jank-build::link-dir=" (pkg-config pc-name "libdir")))
  (println "jank-build::link-library=glfw"))

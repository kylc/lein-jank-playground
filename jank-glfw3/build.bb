(require '[clojure.string :as string]
         '[babashka.fs :as fs]
         '[babashka.process :as proc])

(defn pkg-config [pc-name var]
  (string/trim-newline (:out (proc/sh ["pkg-config" pc-name "--variable" var]))))

(let [pc-name "glfw3"]
  (println (str "jank-build::link-path=" (pkg-config pc-name "libdir")))
  (println (str "jank-build::link-lib=glfw"))
  (println (str "jank-build::include-path=" (pkg-config pc-name "includedir"))))

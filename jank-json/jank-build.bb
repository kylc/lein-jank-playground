;; Demo of a fully manual build script.

(require '[babashka.fs :as fs]
         '[babashka.process :as proc])

(def CXX (System/getenv "CXX"))

(let [{:keys [src-dir out-dir inputs]} *input*]
  (fs/copy-tree (fs/path src-dir "include") (fs/path out-dir "include")
                {:replace-existing true})

  (proc/shell
   [CXX
    "-shared" "-fPIC"
    "-I" (fs/path (get inputs "org.clojars.kylc/jank-json-sys") "include")
    "-I" (fs/path src-dir "include")
    (fs/path src-dir "src/cpp/jank_json.cpp")
    "-o" (fs/path out-dir "libjank_json.so")])

  ;; TODO: support static build
  ;; (proc/shell
  ;;  ["ar" "rcs"
  ;;   (fs/path out-dir "libjank_json.a")
  ;;   (fs/path build-dir "jank_json.o")])

  (println (str "jank-build::include-path=" (fs/path out-dir "include")))
  (println (str "jank-build::link-path=" (fs/path out-dir)))
  (println "jank-build::link-lib=jank_json"))

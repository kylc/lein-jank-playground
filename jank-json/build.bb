(require '[babashka.fs :as fs]
         '[babashka.process :as proc])

(def out-dir (or (System/getenv "OUT_DIR") "install"))

(let [base-dir    (fs/cwd)
      src-dir     (fs/path base-dir "cpp")
      build-dir   (fs/path base-dir "build")
      install-dir (fs/path base-dir out-dir)]
  (proc/shell ["cmake"
               (str "-DCMAKE_INSTALL_PREFIX=" install-dir)
               "-DCMAKE_INSTALL_LIBDIR=lib"
               "-DCMAKE_INSTALL_INCLUDEDIR=include"
               "-Bbuild"
               "."])
  (proc/shell ["cmake" "--build" "build"])
  (proc/shell ["cmake" "--install" "build"])

  (println (str "jank-build::link-path=" (fs/path install-dir "lib")))
  (println (str "jank-build::link-lib=jank_json"))
  (println (str "jank-build::include-path=" (fs/path install-dir "include"))))

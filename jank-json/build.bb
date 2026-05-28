(require '[babashka.fs :as fs]
         '[babashka.process :as proc])

(def src-dir (System/getenv "SRC_DIR"))
(def build-dir (System/getenv "BUILD_DIR"))
(def out-dir (System/getenv "OUT_DIR"))

(proc/shell ["cmake"
             ;; No network connection so we must manually specify the
             ;; FetchContent source.
             "-DFETCHCONTENT_FULLY_DISCONNECTED=TRUE"
             (str "-DFETCHCONTENT_SOURCE_DIR_JSON=" (fs/path src-dir "json"))
             ;; Place output files as instructed by the env.
             (str "-DCMAKE_INSTALL_PREFIX=" out-dir)
             "-DCMAKE_INSTALL_LIBDIR=lib"
             "-DCMAKE_INSTALL_INCLUDEDIR=include"
             "-B" build-dir
             src-dir])
(proc/shell ["cmake" "--build" build-dir])
(proc/shell ["cmake" "--install" build-dir])

(println (str "jank-build::link-path=" (fs/path out-dir "lib")))
(println (str "jank-build::link-lib=jank_json"))
(println (str "jank-build::include-path=" (fs/path out-dir "include")))

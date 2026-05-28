(require '[babashka.fs :as fs]
         '[babashka.process :as proc])

(let [{:keys [src-dir build-dir out-dir optimization-level]} *input*]
  (proc/shell ["cmake"
               (str "-DCMAKE_BUILD_TYPE=" (if (pos? optimization-level) "Release" "Debug"))
               ;; No network connection so we must manually specify the
               ;; FetchContent source.
               (str "-DFETCHCONTENT_SOURCE_DIR_JSON=" (fs/path src-dir "json"))
               ;; Place output files as instructed by the env.
               (str "-DCMAKE_INSTALL_PREFIX=" out-dir)
               "-DCMAKE_INSTALL_INCLUDEDIR=include"
               "-B" build-dir
               src-dir])
  (proc/shell ["cmake" "--build" build-dir "--target" "install"])

  (println (str "jank-build::include-path=" (fs/path out-dir "include"))))

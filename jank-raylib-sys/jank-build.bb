(require '[babashka.fs :as fs]
         '[jank.build.cmake :as cmake])

(let [{:keys [src-dir out-dir]} *input*]
  (cmake/build *input* {:defines {"BUILD_SHARED_LIBS" true}})
  (println (str "jank-build::include-dir=" (fs/path out-dir "include")))
  (println (str "jank-build::link-dir=" (fs/path out-dir "lib64")))
  (println (str "jank-build::link-library=" "raylib")))

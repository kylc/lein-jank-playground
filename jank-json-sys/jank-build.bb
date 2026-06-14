;; Demo of a build script which invokes the CMake helper (referred via
;; project.clj :build-dependencies).

(require '[babashka.fs :as fs]
         '[jank.build.cmake :as cmake])

(let [{:keys [src-dir out-dir]} *input*]
  ;; Override the FetchContent source dir to the local checkout, since we can't
  ;; download it when building in the sandbox.
  (cmake/build *input* {:defines {"JUST_AN_EXAMPLE_DEF" "1"}})

  (println (str "jank-build::include-dir=" (fs/path out-dir "include")))
  (println (str "jank-build::link-dir=" (fs/path out-dir "lib"))))

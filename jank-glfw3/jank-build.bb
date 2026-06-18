;; Demo of a "build script" which invokes pkg-config to find a system
;; dependency.

(require '[jank.build.pkg-config :refer [pkg-config]])

(pkg-config "glfw3")

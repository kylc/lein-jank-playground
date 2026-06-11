(ns jank.build.cmake
  (:require [babashka.fs :as fs]
            [babashka.process :as proc]))

(defn build-type [optimization-level]
  (if (pos? optimization-level)
    "Release"
    "Debug"))

(defn default-defines [{:keys [out-dir optimization-level static-build]}]
  {"CMAKE_BUILD_TYPE"     (build-type optimization-level)
   "CMAKE_INSTALL_PREFIX" out-dir
   "BUILD_SHARED_LIBS"    (if static-build "OFF" "ON")})

(defn build [{:keys [src-dir build-dir out-dir optimization-level static-build] :as opts}
             {:keys [defines target] :or {target "install"}}]
  (let [d-flags (map (fn [[k v]] (str "-D" (name k) "=" v))
                     (merge (default-defines opts) defines))]
    (proc/shell (concat ["cmake"] d-flags ["-B" build-dir src-dir]))
    (proc/shell ["cmake" "--build" build-dir "--target" target])))

(defproject org.clojars.kylc/jank-json-sys "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :build-dependencies [[org.clojars.kylc/jank-build-cmake "0.1-SNAPSHOT"]]
  :verbatim-paths ["CMakeLists.txt" "jank-build.bb" "json"])

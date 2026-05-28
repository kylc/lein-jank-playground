(defproject org.clojars.kylc/jank-json "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :dependencies [[org.clojars.kylc/jank-json-sys "0.1-SNAPSHOT"]]
  :verbatim-paths ["json" "include" "src/cpp"]
  :resource-paths ["jank-build.bb" "CMakeLists.txt"]
  :source-paths ["src/jank"])

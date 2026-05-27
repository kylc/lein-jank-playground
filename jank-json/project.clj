(defproject org.clojars.kylc/jank-json "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :resource-paths ["build.bb" "CMakeLists.txt"]
  :source-paths ["src/jank" "include" "src/cpp"]
  :profiles {:uberjar {:aot :all}})

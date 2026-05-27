(defproject json-formatter "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :main json-formatter.main
  :dependencies [[org.clojars.kylc/jank-json "0.1-SNAPSHOT"]
                 [org.clojars.kylc/jank-glfw3 "0.1-SNAPSHOT"]])

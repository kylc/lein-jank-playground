(defproject org.clojars.kylc/jank-glfw3 "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :build-dependencies [[org.clojars.kylc/jank-build-pkg-config "0.1-SNAPSHOT"]]
  :verbatim-paths ["jank-build.bb"])

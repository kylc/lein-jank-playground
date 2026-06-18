(defproject raylib-demo "0.1-SNAPSHOT"
  :license {:name "MPL 2.0"
            :url  "https://www.mozilla.org/en-US/MPL/2.0/"}
  :plugins [[org.jank-lang/lein-jank "0.7"]]
  :middleware [leiningen.jank/middleware]
  :main raylib-demo.main
  :dependencies [[org.clojars.kylc/jank-raylib-sys "6.0-SNAPSHOT"]]
  :profiles {:base    {:jank {:output-dir         "target/debug"
                              :optimization-level 0}}
             :release {:jank {:output-dir         "target/release"
                              :runtime            :static
                              :optimization-level 2}}})

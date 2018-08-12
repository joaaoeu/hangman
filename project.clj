(defproject hangman "0.1.0-SNAPSHOT"
  :description "Hangman Game"
  :url "https://github.com/joaaoeu/hangman"
  :license {:name "WTFPL"
            :url "http://www.wtfpl.net/"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot hangman.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

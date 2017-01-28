(defproject io.replikativ/kabel "0.1.12-SNAPSHOT"
  :description "A library for simple wire-like connectivity semantics."
  :url "https://github.com/replikativ/kabel"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-alpha14" :scope "provided"]
                 [org.clojure/clojurescript "1.9.229" :scope "provided"]
                 [io.replikativ/superv.async "0.2.4"]

                 [com.cognitect/transit-clj "0.8.285"]
                 [com.cognitect/transit-cljs "0.8.239"]
                 [io.replikativ/incognito "0.2.1"]

                 [io.replikativ/hasch "0.3.4"]

                 [org.slf4j/slf4j-api "1.7.22"] ;; TODO factor logging

                 [http-kit "2.2.0" :scope "provided"] 
                 [http.async.client "1.2.0" :scope "provided"]
                 [org.glassfish.tyrus/tyrus-core "1.13"]
                 [aleph "0.4.2-alpha8" :scope "provided"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.8"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :figwheel {:nrepl-port 7888
                              :nrepl-middleware ["cider.nrepl/cider-middleware"
                                                 "cemerick.piggieback/wrap-cljs-repl"]}
                   :plugins [[lein-figwheel "0.5.8"]]
                   :repl-options {; for nREPL dev you really need to limit output
                                  :init (set! *print-length* 50)
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
  :cljsbuild
  {:builds [{:id "cljs_repl"
             :source-paths ["src"]
             :figwheel true
             :compiler
             {:main kabel.client
              :asset-path "js/out"
              :output-to "resources/public/js/client.js"
              :output-dir "resources/public/js/out"
              :optimizations :none
              :pretty-print true}}]}
  )

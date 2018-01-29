(ns tunermin.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)
;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Tunermin"}))

(defn tunermin-app []
  [:div
   [:h1 (:text @app-state)]])

(reagent/render-component [tunermin-app]
                          (. js/document (getElementById "app")))

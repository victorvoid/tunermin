(ns tunermin.core
  (:require [reagent.core :as reagent :refer [atom]]
            [tunermin.tuner :as tuner]
            [tunermin.strings :as string]))

(enable-console-print!)

(defonce app-state (atom {:text "Tunermin"}))

(.log js/console (tuner/get-note-frequencies (:e2 string/strings) string/notes 20))

(defn tunermin-app []
  [:div
   [:h1 (:text @app-state)]])

(reagent/render-component [tunermin-app]
                          (. js/document (getElementById "app")))

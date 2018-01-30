(ns tunermin.core
  (:require [reagent.core :as reagent :refer [atom]]
            [tunermin.tuner :as tuner]))

(enable-console-print!)

(defonce app-state (atom {:text "Tunermin"}))
(def notes ["C" "C#" "D" "D#" "E" "F" "F#" "G" "G#" "A" "A#" "B"])
(def E2
  "Guitar strings are E2=82.41Hz `https://www.seventhstring.com/resources/notefrequencies.html`"
  82.41)

(.log js/console (tuner/get-note-frequencies E2 notes))

(defn tunermin-app []
  [:div
   [:h1 (:text @app-state)]])

(reagent/render-component [tunermin-app]
                          (. js/document (getElementById "app")))

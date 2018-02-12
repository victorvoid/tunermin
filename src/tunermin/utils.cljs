(ns tunermin.utils)

(defn exp
  [x y]
  (.pow js/Math x y))

(defn getUserAudio
  []
  (js/navigator.mediaDevices.getUserMedia  {:audio true :video false}))

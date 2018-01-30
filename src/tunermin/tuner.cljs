(ns tunermin.tuner
  (:require [tunermin.utils :refer [exp]]))

(defn get-note-frequencies
  [freq-note notes quantity]
  (loop [frequencies []
         i           0]
    (if (< i quantity)
      (let [curr-frequency (* freq-note (exp 2 (/ i 12)))
            curr-note-name (nth notes (mod i 12))
            flat           {:frequency (* curr-frequency (exp 2 (/ -1 48)))
                            :name      (str curr-note-name " (a bit flat)")}
            curr-note      {:frequency curr-frequency :name curr-note-name}
            sharp          {:frequency (* curr-frequency (exp 2 (/ 1 48)))
                            :name      (str curr-note-name " (a bit sharp)")}]
        (.log js/console (exp 2 (/ i 12)))
        (recur (conj frequencies flat curr-note sharp) (inc i)))
      frequencies)))


(ns app.updater.core
  (:require [respo.cursor :refer [mutate]]))

(defn updater [store op op-data]
  (case op
    :states (update store :states (mutate op-data))
    :inc (update store :pointer inc)
    :dec (update store :pointer dec)
    store))

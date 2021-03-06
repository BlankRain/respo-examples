
(ns app.comp.button
  (:require-macros [respo.macros :refer [defcomp <> div span]])
  (:require
    [respo.core :refer [create-comp]]
    [hsl.core :refer [hsl]]))

(defcomp comp-button [text on-click]
  (div {:style {:background-color (hsl 200 80 70)
                :display "inline-block"
                :padding "0 8px"
                :color "white"
                :margin "0 8px"
                :cursor "pointer"}
        :on {:click on-click}}
    (<> span text nil)))


(ns spa-example.comp.container
  (:require
    [respo.alias :refer [create-comp create-element with-cursor div span]]
    [spa-example.comp.button :refer [comp-button]]
    [spa-example.comp.box :refer [comp-box]]))

; create element if not in project yet
(defn hr [props & children]
  (create-element :hr props children))

(defn handle-inc [simple-event dispatch!]
  (dispatch! :inc 1))

(defn handle-dec-with-log [state store]
  (fn [simple-event dispatch!]
    (println "some info:" state store)
    (dispatch! :dec 1)))

(defn render [store]
  (fn [cursor]
    (let [states (:states store)
          state (:data states)]
      (div {}
        (div {}
          (span {:attrs {:inner-text "Demo of component with mutate"}})
          (comp-box state 5))
        (hr {})
        (span {:attrs {:inner-text "Demo of list of them"}})
        (div {}
          (->> (range 10)
            (map-indexed (fn [index n]
              [index (with-cursor n (comp-box (get states n) n))]))))
        (hr {})
        (div {}
          (span {:attrs {:inner-text "Demo of dispatch:"}})
          (comp-button "inc" handle-inc)
          (comp-button "dec" (handle-dec-with-log state store))
          (span {:attrs {:inner-text (str store)}}))))))

(def comp-container (create-comp :container render))
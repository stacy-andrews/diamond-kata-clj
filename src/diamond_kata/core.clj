(ns diamond-kata.core
  (:gen-class))

(defn spaces [number] (clojure.string/join "" (take number (repeat " "))))

(defn outer-spaces
  [idx, original_count]
  (spaces (- original_count (+ idx 1)))
)

(defn top
  [itm original_count]
  (str (outer-spaces 0 original_count) itm (outer-spaces 0 original_count)))

(defn inner-spaces
  [idx]
  (spaces (- (* idx 2) 1))
)

(defn process-item
  [idx, itm, original_count]
  (if (= idx 0)
    (top itm original_count)
    (str (outer-spaces idx original_count) itm (inner-spaces idx) itm (outer-spaces idx original_count))))

(defn flat-indx
  [idx, count_of, original_count]
  (if (< (+ idx 1) original_count)
    idx
    (- count_of (+ idx 1))))

(defn process-items
  [items]
  (def all-items (into items (rest (reverse items))))
  (def all-item-count (count all-items))
  (def item-count (count items))
  (clojure.string/join "\n" (map-indexed (fn [idx, itm] (process-item (flat-indx idx all-item-count item-count) itm item-count)) all-items)))

(defn diamond-hoo-ha
  "implementation of diamond kata"
  [items]
  (if (= (count items) 1)
    (first items)
    (process-items items)))

(defn -main
  "Prints a diamond with each arg being a item for the diamond"
  [& args]
    (println args)
    (println (diamond-hoo-ha (into [] args))))

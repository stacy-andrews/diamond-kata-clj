(ns diamond-kata.core-test
  (:require [clojure.test :refer :all]
            [diamond-kata.core :refer :all]))

(deftest a-test
  (testing "single item returns the item"
    (is (= (diamond-hoo-ha ["A"]) "A")))
  (testing "simplest diamond"
    (is (= (diamond-hoo-ha '("A" "B"))
" A 
B B
 A ")))
  (testing "processing"
    (is (= (process-item 1, "B", 3) " B B "))
    (is (= (process-item 2, "C", 3) "C   C"))
  )

)

    ;  A
    ; B B
    ;  A

    ;    A
    ;   B B
    ;  C   C
    ;   B B
    ;    A

    ;     A
    ;    B B
    ;   C   C
    ;  D     D
    ;   C   C
    ;    B B
    ;     A
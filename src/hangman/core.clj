(ns hangman.core
  (:gen-class))

(def totalLifes 6)
(def secretWord "Clojure")

(defn toUppercase [x] (clojure.string/upper-case x))

(defn remainingLetters [word hits]
  (remove (fn [letter] (contains? hits (str letter))) word))

(defn hitAllWord? [word hits]
  (empty? (remainingLetters word hits)))

(defn right? [guess word] (.contains word guess))

(defn getHangman [lifes word hits]
  (println "Lifes:" lifes)
  (if (> lifes 0)
    (do
      (doseq [letter (seq word)]
        (if (contains? hits (str letter))
          (print letter " ")
          (print "_" " ")))
      (println)
      (println "Take a guess..."))
    (do
      (doseq [letter (seq word)]
        (print letter " "))
      (println))))

(defn game [lifes word hits]
  (getHangman lifes (toUppercase word) hits)
  (cond
    (= lifes 0) (println "Game Over!")
    (hitAllWord? (toUppercase word) hits) (println "You Win!")
    :else
    (do
      (let [guess (read-line)]
        (if (right? (toUppercase guess) (toUppercase word))
          (do
            (println)
            (println "***** You right! *****")
            (recur lifes word (conj hits (toUppercase guess))))
          (do
            (println)
            (println "***** You wrong! *****")
            (recur (dec lifes) word hits)))))))

(defn startGame [] (game totalLifes secretWord #{}))

(defn -main [& args]
  (startGame))

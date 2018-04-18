# 5x5 の BINGO を 作成するアプリ(Java 10 を 使っています。)


実行前準備
----------

bingo_target.txt を 作成し、jarと同じディレクトリに置いてください。

ID には、1から順番にシーケンシャルにデータを入れてください。

|ID    |TARGET_NAME |
|-----:|:----------:|
|1     |佐藤1郎     |
|2     |鈴木2郎     |
|3     |高橋3郎     |
|4     |田中4郎     |
|...   |            |
|50    |伊藤50郎    |


実行
----

```
mvn package
cp bingo_target.txt target/
java -jar target/bingo-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
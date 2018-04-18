# 5x5 の BINGO を 作成するアプリ(Java 10 を 使っています。)


実行前準備
----------

bingo_target.txt を 作成し、jarと同じディレクトリにおいてください。

ID には、1から順番にシーケンシャルにデータを入れてください。

|      |            |
|-----:|:----------:|
|1     |taro        |
|2     |jiro        |
|...   |            |
|50    |gojyuro     |


実行
----

```
mvn package
cp bingo_target.txt target/
java -jar target/bingo-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
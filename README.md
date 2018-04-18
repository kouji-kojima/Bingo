# 5x5 の BINGO を 作成するアプリ


事前準備
--------

[bingo_target.txt](https://github.com/kouji-kojima/Bingo/blob/master/bingo_target.txt) を 作成し、jarと同じディレクトリに置いてください。

ID には、1から順番にシーケンシャルにデータを入れてください。

|DATA        |
|:-----------|
|1,佐藤1郎   |
|2,鈴木2郎   |
|3,高橋3郎   |
|4,田中4郎   |
|...         |
|50,伊藤50郎 |


実行
----

jar の 引数に作りたいビンゴ数を入力するか、忘れても標準入力から入れてください。

```
java -jar bingo.jar 100
```

※Java 10 を 使っています。

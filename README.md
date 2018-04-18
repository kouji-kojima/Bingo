# 5x5 の BINGO を 作成するアプリ


実行前準備
----------

1.Bingo5x5Appを修正してください。

```
/** 何枚ビンゴを作成するか？ How many Bingo ? */
private static int BINGO_NUM = 36;

/** ＤＢ情報 */
private static String DB_INFO = "jdbc:oracle:thin:@IP:PORT:ORCL"; // 今回はオラクルのサンプルです。
private static String DB_USER = "user";
private static String DB_PASS = "pass";

/** ビンゴの中に埋める文字を格納しているテーブル。IDには1～シーケンスに登録しておく。 */
private static String BINGO_TARGET_SQL = "SELECT id, target_name FROM BINGO_TARGET_TBL";

/** ビンゴ出力先 */
private static String BINGO_OUTPUT_PATH = "C:\\temp\\bingo.csv";
```

2.BINGO\_TARGET\_TBLテーブルを作成してください。

```
CREATE TABLE BINGO_TARGET_TBL
(
    ID                             NUMBER NOT NULL,
    TARGET_NAME                    VARCHAR2(100),
    CONSTRAINT BINGO_TARGET_PK PRIMARY KEY (ID) USING INDEX
)
```

3.テーブルにビンゴのマスの中に表示するデータを事前に入れてください。

ID には、1から順番にシーケンシャルにデータを入れてください。

|ID    |TARGET_NAME |
|-----:|:----------:|
|1     |taro        |
|2     |jiro        |
|...   |            |
|50    |gojyuro     |



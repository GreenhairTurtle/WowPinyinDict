public enum Data {

    //稀有，宝箱
    VIGNETTE    ("vignette.csv","Name_lang", 1),
    //地图
    UIMAP("uimap.csv", "Name_lang", 0),
    //外观-套装
    TRANSMOGSET("transmogset.csv", "Name_lang", 0),
    //坐骑
    MOUNT("mount.csv", "Name_lang", 0);

    String column;
    String path;
    int columnIndex;

    Data(String path, String column, int columnIndex) {
        this.path = path;
        this.column = column;
        this.columnIndex = columnIndex;
    }
}

public enum Data {

    //稀有，宝箱
    VIGNETTE    ("vignette.csv","Name_lang", 1),
    //地图
    UIMAP("uimap.csv", "Name_lang", 0),
    //外观-套装
    TRANSMOGSET("transmogset.csv", "Name_lang", 0),
    //坐骑
    MOUNT("mount.csv", "Name_lang", 0),
    //技能名称
//    SPELLNAME("spellname.csv", "Name_lang", 1),
    //控制效果
    SPELLMECHANIC("spellmechanic.csv", "StateName_lang", 1),
//    SPELLFOCUSOBJECT("spellfocusobject.csv", "Name_lang", 1),
//    SPELLFLYOUT("spellflyout.csv", "Name_lang", 2),
    //可驱散类型
    SPELLDISPELTYPE("spelldispeltype.csv", "Name_lang", 1),
    //灵魂羁绊
    SOULBIND("soulbind.csv", "Name_lang", 1),
    //场景
    SCENARIO("scenario.csv", "Name_lang", 1),
    //挖掘场
    RESEARCHSITE("researchsite.csv", "Name_lang", 1),
    //QuestInfo
//    QUESTINFO("questinfo.csv", "Name_lang", 1),
    //PVP目标
//    PVPSTAT("pvpstat.csv", "Description_lang", 0),
    //地图
    MAP("map.csv", "MapName_lang", 2),
    //语言
    LANGUAGES("languages.csv", "Name_lang", 1),
    //词缀
    KEYSTONEAFFIX("keystoneaffix.csv", "Name_lang", 0),
    JOURNALTIER("journaltier.csv", "Name_lang", 1),
    JOURNALINSTANCE("journalinstance.csv", "Name_lang", 1),
    //地下城手册boss
    JOURNALENCOUNTERCREATURE("journalencountercreature.csv", "Name_lang", 0),
    //地下城手册boss
    JOURNALENCOUNTER("journalencounter.csv", "Name_lang", 0),
    //item subclass
    ITEMSUBCLASS("itemsubclass.csv", "DisplayName_lang", 0),
//    //item set
//    ITEMSET("itemset.csv", "Name_lang", 1),
    //item set food
    ITEMPETFOOD("itempetfood.csv", "Name_lang", 1),
//    //item limit category
//    ITEMLIMITCATEGORY("itemlimitcategory.csv", "Name_lang", 1),
    //item class
    ITEMCLASS("itemclass.csv", "ClassName_lang", 1),
//    //holiday names
    HOLIDAYNAMES("holidaynames.csv", "Name_lang", 1),
//    GARRTALENT("garrtalent.csv", "Name_lang", 0),
//    GARRSPECIALIZATION("garrspecialization.csv", "Name_lang", 1),
    FACTION("faction.csv", "Name_lang", 5),
    CURRENCYTYPES("currencytypes.csv", "Name_lang", 1),
    CURRENCYCONTAINER("currencycontainer.csv", "ContainerName_lang", 1),
    CREATURETYPE("creaturetype.csv", "Name_lang", 1),
    CREATUREFAMILY("creaturefamily.csv", "Name_lang", 1),
    CREATURE("creature.csv", "Name_lang", 1),
    COVENANT("covenant.csv", "Name_lang", 1),
//    CHRSPECIALIZATION("chrspecialization.csv", "Name_lang", 0),
//    CHRCLASSTITLE("chrclasstitle.csv", "Name_male_lang", 1),
//    CHRCLASSES("chrclasses.csv", "Name_lang", 0),
    //战役
    CAMPAIGN("campaign.csv", "Title_lang", 1),
    BATTLEPETABILITY("battlepetability.csv", "Name_lang", 1),
//    //神器
    ARTIFACT("artifact.csv", "Name_lang", 0),
//    AREAPOI("areapoi.csv", "Name_lang", 0);
;

    String column;
    String path;
    int columnIndex;

    Data(String path, String column, int columnIndex) {
        this.path = path;
        this.column = column;
        this.columnIndex = columnIndex;
    }
}

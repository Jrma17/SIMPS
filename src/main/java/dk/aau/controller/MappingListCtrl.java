package dk.aau.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import dk.aau.model.MappingListModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class MappingListCtrl {

    @FXML
    public ListView<String> listView;
    @FXML
    private Label Icpc;

    public StringProperty isolatedIcdCodes = new SimpleStringProperty(""); 
    private MappingListModel MapStructure = new MappingListModel();
    private HashMap<String, List<String>> NewMap;

    private String icpcCode;

    public void setCode(String code) { // Henter ICPC kode værdien fra "ReferralCtrl"
        icpcCode = code;        
        Icpc.setText(icpcCode);
        
        // Isolerer values fra "NewMap" (HashMap som har ICPC kode som key, og en tilhørende liste af ICD-10 koder som value), som har "icpcCode" som key
        Object relevanteICD = NewMap.get(icpcCode); // Hashmaps returnere objects
        String val = String.valueOf(relevanteICD); // Omdanner Object til String (det skal være String, når det skal sættes ind i listview'et)
        
        String[] arrOfStr = val.split("0,", 0); // Splitter en String i flere Strings, hver gang der er et "0," (vi bruger "0," da der kan forekomme "," i koden)

        for (String isolatedICDCodes : arrOfStr) { // Gør efterfølgende for alle strings i arrayet
            isolatedICDCodes = isolatedICDCodes.replace("[", ""); // Erstatter [ med ingenting
            isolatedICDCodes = isolatedICDCodes.replace("]", ""); // Erstatter ] med ingenting
            isolatedICDCodes = isolatedICDCodes.trim(); // Fjerner eventuelle overskydende mellemrum
            listView.getItems().add(isolatedICDCodes); // Tilføjer de isolerede og tilpassede værdier til listview
        }
    }

    @FXML // Funktionen er tilkoblet ListView i "MappingListView" under code (on mouse clicked) og styrer hvad der sker når der klikkes
    public void clickItemMap(MouseEvent event) throws IOException {
        if (event.getClickCount() == 2) // Der skal dobbelt-klikkes. 
        {
            // Tjekker hvilken værdi der er dobbeltklikket på i listView og sætter denne i "isolatedIcdCodes"
            isolatedIcdCodes.set(listView.getSelectionModel().getSelectedItem()); 
            listView.getScene().getWindow().hide(); // Lukker vinduet når der er dobbeltklikket
        }
    }

    public void initialize() { // Initialize køres som det første, efterfølgende køres det resterende
        MappingMethod(); // Opsætter hashmappet og dermed mapningen
    }

    public HashMap<String, List<String>> MappingMethod() { // Metode som opsætter mapning
        
        NewMap = MapStructure.getNewMap(); // NewMap består af MapStructure (som er en struktur for mappet og hentes (getMap) fra "MappingListModel")
        
        // Alle values er en liste (fordi der kan være flere ICD-10 koder til én ICPC kode) - disse oprettes her: 
        List<String> icdToL70 = new ArrayList<String>();
        icdToL70.add("dm865"); icdToL70.add("dm650"); icdToL70.add("dm651"); icdToL70.add("dm710"); icdToL70.add("dm711"); icdToL70.add("dm860"); 
        icdToL70.add("dm861"); icdToL70.add("dm862"); icdToL70.add("dm864"); icdToL70.add("dm866"); icdToL70.add("dm868"); icdToL70.add("dm869"); 
        icdToL70.add("dm018"); icdToL70.add("dm600"); icdToL70.add("dm863"); icdToL70.add("dm009"); icdToL70.add("dm465"); icdToL70.add("dm463"); 
        icdToL70.add("dm008"); icdToL70.add("dm010"); icdToL70.add("dm011"); icdToL70.add("dm012"); icdToL70.add("dm013"); icdToL70.add("dm464"); 
        icdToL70.add("dm015"); icdToL70.add("dm016"); icdToL70.add("dm001"); icdToL70.add("dm462"); icdToL70.add("dm000"); icdToL70.add("dm014"); 
        icdToL70.add("dm002");

        List<String> icdToL71 = new ArrayList<String>();
        icdToL71.add("dc490"); icdToL71.add("dc491"); icdToL71.add("dc492"); icdToL71.add("dc493"); icdToL71.add("dc494"); icdToL71.add("dc495"); 
        icdToL71.add("dc496"); icdToL71.add("dc499"); icdToL71.add("dc461"); icdToL71.add("dc410"); icdToL71.add("dc498"); icdToL71.add("dc409"); 
        icdToL71.add("dc400"); icdToL71.add("dc401"); icdToL71.add("dc402"); icdToL71.add("dc412"); icdToL71.add("dc408"); icdToL71.add("dc419"); 
        icdToL71.add("dc411"); icdToL71.add("dc413"); icdToL71.add("dc414"); icdToL71.add("dc418"); icdToL71.add("dc403");
        
        List<String> icdToL72 = new ArrayList<String>();
        icdToL72.add("ds520"); icdToL72.add("ds526"); icdToL72.add("ds529"); icdToL72.add("ds528"); icdToL72.add("ds527"); icdToL72.add("ds524"); 
        icdToL72.add("ds523"); icdToL72.add("ds521"); icdToL72.add("ds522"); icdToL72.add("ds525");
        
        List<String> icdToL73 = new ArrayList<String>();
        icdToL73.add("ds827"); icdToL73.add("ds828"); icdToL73.add("ds826"); icdToL73.add("ds825"); icdToL73.add("ds824"); icdToL73.add("ds823"); 
        icdToL73.add("ds822"); icdToL73.add("ds821"); icdToL73.add("ds829");

        List<String> icdToL74 = new ArrayList<String>();
        icdToL74.add("ds623"); icdToL74.add("ds921"); icdToL74.add("ds929"); icdToL74.add("ds927"); icdToL74.add("ds925"); icdToL74.add("ds924"); 
        icdToL74.add("ds923"); icdToL74.add("ds922"); icdToL74.add("ds920"); icdToL74.add("ds628"); icdToL74.add("ds627"); icdToL74.add("ds626"); 
        icdToL74.add("ds624"); icdToL74.add("ds622"); icdToL74.add("ds621"); icdToL74.add("ds620"); icdToL74.add("ds625");

        List<String> icdToL75 = new ArrayList<String>();
        icdToL75.add("ds728"); icdToL75.add("ds727"); icdToL75.add("ds729"); icdToL75.add("ds723"); icdToL75.add("ds720"); icdToL75.add("ds722"); 
        icdToL75.add("ds721"); icdToL75.add("ds724");

        List<String> icdToL76 = new ArrayList<String>();
        icdToL76.add("ds428"); icdToL76.add("ds322"); icdToL76.add("ds323"); icdToL76.add("ds324"); icdToL76.add("ds325"); icdToL76.add("ds327"); 
        icdToL76.add("ds328"); icdToL76.add("ds420"); icdToL76.add("ds421"); icdToL76.add("ds422"); icdToL76.add("ds423"); icdToL76.add("ds321"); 
        icdToL76.add("ds427"); icdToL76.add("dt129"); icdToL76.add("ds429"); icdToL76.add("ds820"); icdToL76.add("dt089"); icdToL76.add("dt109"); 
        icdToL76.add("dt142"); icdToL76.add("ds022"); icdToL76.add("ds424"); icdToL76.add("ds028"); icdToL76.add("ds320"); icdToL76.add("ds024"); 
        icdToL76.add("ds026"); icdToL76.add("ds027"); icdToL76.add("ds029"); icdToL76.add("ds120"); icdToL76.add("ds121"); icdToL76.add("ds122"); 
        icdToL76.add("ds127"); icdToL76.add("ds129"); icdToL76.add("ds220"); icdToL76.add("ds221"); icdToL76.add("ds222"); icdToL76.add("ds223"); 
        icdToL76.add("ds224"); icdToL76.add("ds229"); icdToL76.add("ds225"); icdToL76.add("ds228"); icdToL76.add("ds128"); icdToL76.add("ds023");

        List<String> icdToL77 = new ArrayList<String>();
        icdToL77.add("ds934");

        List<String> icdToL78 = new ArrayList<String>();
        icdToL78.add("ds834"); icdToL78.add("ds836"); 

        List<String> icdToL79 = new ArrayList<String>();
        icdToL79.add("ds936"); icdToL79.add("ds935"); icdToL79.add("ds932"); icdToL79.add("ds731"); icdToL79.add("ds637"); icdToL79.add("ds636"); 
        icdToL79.add("ds635"); icdToL79.add("ds633"); icdToL79.add("ds634"); icdToL79.add("ds436"); icdToL79.add("dt143"); icdToL79.add("ds035"); 
        icdToL79.add("ds532"); icdToL79.add("ds534"); icdToL79.add("ds034"); icdToL79.add("ds135"); icdToL79.add("ds136"); icdToL79.add("ds234"); 
        icdToL79.add("ds235"); icdToL79.add("ds434"); icdToL79.add("ds435"); icdToL79.add("ds437"); icdToL79.add("ds533");

        List<String> icdToL80 = new ArrayList<String>();
        icdToL80.add("dt112"); icdToL80.add("dt632"); icdToL80.add("dt531"); icdToL80.add("dt630"); icdToL80.add("dt330"); icdToL80.add("dt631"); 
        icdToL80.add("dt433"); icdToL80.add("dt530"); icdToL80.add("dt730"); icdToL80.add("dt830"); icdToL80.add("dt831"); icdToL80.add("dt930"); 
        icdToL80.add("dt931"); icdToL80.add("dt092"); icdToL80.add("dt132"); icdToL80.add("dt143"); icdToL80.add("dt933"); icdToL80.add("dm221"); 
        icdToL80.add("dt432"); icdToL80.add("dt332"); icdToL80.add("dm220"); icdToL80.add("dt030"); icdToL80.add("dt033"); icdToL80.add("dt130"); 
        icdToL80.add("dt131"); icdToL80.add("dt132"); icdToL80.add("dt430"); icdToL80.add("dt230"); icdToL80.add("dt231"); icdToL80.add("dt232"); 
        icdToL80.add("dt331"); icdToL80.add("dt333"); icdToL80.add("dt133"); icdToL80.add("dt431");
        
        List<String> icdToL81 = new ArrayList<String>();
        icdToL81.add("ds868"); icdToL81.add("ds869"); icdToL81.add("ds870"); icdToL81.add("ds878"); icdToL81.add("ds880"); icdToL81.add("ds881"); 
        icdToL81.add("ds889"); icdToL81.add("ds961"); icdToL81.add("ds898"); icdToL81.add("ds899"); icdToL81.add("ds960"); icdToL81.add("ds867"); 
        icdToL81.add("ds781"); icdToL81.add("ds897"); icdToL81.add("ds789"); icdToL81.add("ds764"); icdToL81.add("ds767"); icdToL81.add("ds770"); 
        icdToL81.add("ds771"); icdToL81.add("ds772"); icdToL81.add("ds797"); icdToL81.add("ds982"); icdToL81.add("ds863"); icdToL81.add("ds962"); 
        icdToL81.add("ds798"); icdToL81.add("ds799"); icdToL81.add("ds860"); icdToL81.add("ds861"); icdToL81.add("ds862"); icdToL81.add("ds780"); 
        icdToL81.add("dt064"); icdToL81.add("dt147"); icdToL81.add("dt146"); icdToL81.add("dt143"); icdToL81.add("dt139"); icdToL81.add("dt138"); 
        icdToL81.add("dt136"); icdToL81.add("dt135"); icdToL81.add("dt119"); icdToL81.add("dt118"); icdToL81.add("dt116"); icdToL81.add("dt115"); 
        icdToL81.add("dt099"); icdToL81.add("dt098"); icdToL81.add("ds981"); icdToL81.add("ds763"); icdToL81.add("ds968"); icdToL81.add("ds969"); 
        icdToL81.add("ds970"); icdToL81.add("ds971"); icdToL81.add("ds978"); icdToL81.add("dt096"); icdToL81.add("ds561"); icdToL81.add("dt095"); 
        icdToL81.add("ds983"); icdToL81.add("ds984"); icdToL81.add("ds997"); icdToL81.add("ds998"); icdToL81.add("ds999"); icdToL81.add("ds967"); 
        icdToL81.add("ds980"); icdToL81.add("ds469"); icdToL81.add("ds578"); icdToL81.add("ds570"); icdToL81.add("ds568"); icdToL81.add("ds567"); 
        icdToL81.add("ds565"); icdToL81.add("ds564"); icdToL81.add("ds562"); icdToL81.add("ds560"); icdToL81.add("ds499"); icdToL81.add("ds498"); 
        icdToL81.add("ds497"); icdToL81.add("ds489"); icdToL81.add("ds481"); icdToL81.add("ds579"); icdToL81.add("ds460"); icdToL81.add("ds762"); 
        icdToL81.add("ds563"); icdToL81.add("dm795"); icdToL81.add("ds099"); icdToL81.add("ds169"); icdToL81.add("ds480"); icdToL81.add("ds390"); 
        icdToL81.add("ds479"); icdToL81.add("ds461"); icdToL81.add("ds462"); icdToL81.add("ds463"); icdToL81.add("ds467"); icdToL81.add("ds468"); 
        icdToL81.add("ds091"); icdToL81.add("ds334"); icdToL81.add("ds682"); icdToL81.add("ds760"); icdToL81.add("ds761"); icdToL81.add("ds698"); 
        icdToL81.add("ds697"); icdToL81.add("ds689"); icdToL81.add("ds688"); icdToL81.add("ds580"); icdToL81.add("ds683"); icdToL81.add("ds699"); 
        icdToL81.add("ds681"); icdToL81.add("ds680"); icdToL81.add("ds678"); icdToL81.add("ds670"); icdToL81.add("ds669"); icdToL81.add("ds599"); 
        icdToL81.add("ds581"); icdToL81.add("ds589"); icdToL81.add("ds684"); icdToL81.add("ds668"); icdToL81.add("ds598"); icdToL81.add("ds660"); 
        icdToL81.add("ds661"); icdToL81.add("ds662"); icdToL81.add("ds663"); icdToL81.add("ds664"); icdToL81.add("ds665"); icdToL81.add("ds666"); 
        icdToL81.add("ds667"); icdToL81.add("ds597");

        
        List<String> icdToL82 = new ArrayList<String>();
        icdToL82.add("dq766"); icdToL82.add("dq759"); icdToL82.add("dq753"); icdToL82.add("dq754"); icdToL82.add("dq755"); icdToL82.add("dq758"); 
        icdToL82.add("dq760"); icdToL82.add("dq761"); icdToL82.add("dq762"); icdToL82.add("dq763"); icdToL82.add("dq765"); icdToL82.add("dq767"); 
        icdToL82.add("dq764"); icdToL82.add("dq752"); icdToL82.add("dq751"); icdToL82.add("dq750"); icdToL82.add("dq749"); icdToL82.add("dq748"); 
        icdToL82.add("dq743"); icdToL82.add("dq742"); icdToL82.add("dq741"); icdToL82.add("dq740"); icdToL82.add("dq731"); icdToL82.add("dq768"); 
        icdToL82.add("dq728"); icdToL82.add("dq783"); icdToL82.add("dq727"); icdToL82.add("dq729"); icdToL82.add("dq784"); icdToL82.add("dq730"); 
        icdToL82.add("dq726"); icdToL82.add("dq798"); icdToL82.add("dq796"); icdToL82.add("dq795"); icdToL82.add("dq794"); icdToL82.add("dq793"); 
        icdToL82.add("dq792"); icdToL82.add("dq791"); icdToL82.add("dq790"); icdToL82.add("dq789"); icdToL82.add("dq788"); icdToL82.add("dq781"); 
        icdToL82.add("dq785"); icdToL82.add("dq769"); icdToL82.add("dq782"); icdToL82.add("dq799"); icdToL82.add("dq780"); icdToL82.add("dq779"); 
        icdToL82.add("dq778"); icdToL82.add("dq777"); icdToL82.add("dq776"); icdToL82.add("dq775"); icdToL82.add("dq774"); icdToL82.add("dq773"); 
        icdToL82.add("dq772"); icdToL82.add("dq771"); icdToL82.add("dq770"); icdToL82.add("dq786"); icdToL82.add("dq662"); icdToL82.add("dq678"); 
        icdToL82.add("dq677"); icdToL82.add("dq676"); icdToL82.add("dq675"); icdToL82.add("dq673"); icdToL82.add("dq671"); icdToL82.add("dq670"); 
        icdToL82.add("dq669"); icdToL82.add("dq668"); icdToL82.add("dq667"); icdToL82.add("dq666"); icdToL82.add("dq665"); icdToL82.add("dq680"); 
        icdToL82.add("dq663"); icdToL82.add("dq674"); icdToL82.add("dq661"); icdToL82.add("dq660"); icdToL82.add("dq659"); icdToL82.add("dq658"); 
        icdToL82.add("dq656"); icdToL82.add("dq655"); icdToL82.add("dq654"); icdToL82.add("dq653"); icdToL82.add("dq652"); icdToL82.add("dq651"); 
        icdToL82.add("dq650"); icdToL82.add("dq725"); icdToL82.add("dq738"); icdToL82.add("dq664"); icdToL82.add("dq718"); icdToL82.add("dq710"); 
        icdToL82.add("dq711"); icdToL82.add("dq712"); icdToL82.add("dq681"); icdToL82.add("dq714"); icdToL82.add("dq709"); icdToL82.add("dq716"); 
        icdToL82.add("dq713"); icdToL82.add("dq719"); icdToL82.add("dq720"); icdToL82.add("dq721"); icdToL82.add("dq722"); icdToL82.add("dq723"); 
        icdToL82.add("dq724"); icdToL82.add("dq672"); icdToL82.add("dq690"); icdToL82.add("dq683"); icdToL82.add("dq715"); icdToL82.add("dq704"); 
        icdToL82.add("dq685"); icdToL82.add("dq682"); icdToL82.add("dq688"); icdToL82.add("dq684"); icdToL82.add("dq691"); icdToL82.add("dq692"); 
        icdToL82.add("dq699"); icdToL82.add("dq700"); icdToL82.add("dq701"); icdToL82.add("dq702"); icdToL82.add("dq703");
        
        List<String> icdToL83 = new ArrayList<String>();
        icdToL83.add("dm489"); icdToL83.add("dm501"); icdToL83.add("dm502"); icdToL83.add("dm503"); icdToL83.add("dm508"); icdToL83.add("dm500"); 
        icdToL83.add("dm509"); icdToL83.add("dm530"); icdToL83.add("dm531"); icdToL83.add("dm538"); icdToL83.add("ds134"); icdToL83.add("dm436"); 
        icdToL83.add("dm488"); icdToL83.add("dm539"); icdToL83.add("dm434"); icdToL83.add("dm471"); icdToL83.add("dm485"); icdToL83.add("dm430"); 
        icdToL83.add("dm433"); icdToL83.add("dm435"); icdToL83.add("dm460"); icdToL83.add("dm472"); icdToL83.add("dm478"); icdToL83.add("dm479"); 
        icdToL83.add("dm480"); icdToL83.add("dm481"); icdToL83.add("dm483"); icdToL83.add("dm484"); icdToL83.add("dm431");
        
        List<String> icdToL84 = new ArrayList<String>();
        icdToL84.add("ds337"); icdToL84.add("dm519"); icdToL84.add("dm489"); icdToL84.add("dm512"); icdToL84.add("dm513"); icdToL84.add("dm514"); 
        icdToL84.add("dm518"); icdToL84.add("dm532"); icdToL84.add("dm533"); icdToL84.add("dm538"); icdToL84.add("dm539"); icdToL84.add("ds233"); 
        icdToL84.add("ds336"); icdToL84.add("dm483"); icdToL84.add("ds335"); icdToL84.add("dm435"); icdToL84.add("dm485"); icdToL84.add("dm431"); 
        icdToL84.add("dm488"); icdToL84.add("dm460"); icdToL84.add("dm461"); icdToL84.add("dm468"); icdToL84.add("dm469"); icdToL84.add("dm478"); 
        icdToL84.add("dm479"); icdToL84.add("dm480"); icdToL84.add("dm481"); icdToL84.add("dm482"); icdToL84.add("dm484"); icdToL84.add("dm470"); 
        icdToL84.add("dm430");

        List<String> icdToL85 = new ArrayList<String>();
        icdToL85.add("dm401"); icdToL85.add("dm418"); icdToL85.add("dm413"); icdToL85.add("dm412"); icdToL85.add("dm411"); icdToL85.add("dm410"); 
        icdToL85.add("dm405"); icdToL85.add("dm404"); icdToL85.add("dm402"); icdToL85.add("dm400"); icdToL85.add("dm403"); icdToL85.add("dm419"); 
        icdToL85.add("dm438"); icdToL85.add("dm439"); icdToL85.add("dm415"); icdToL85.add("dm414");

        List<String> icdToL86 = new ArrayList<String>();
        icdToL86.add("dm514 - Schmorlsk impression0"); icdToL86.add("dm544 - L\u00E6ndesmerter med ischias0"); 
        icdToL86.add("dm543 - Ischias0"); icdToL86.add("dm518 - Anden sygdom i lumbal eller torakal b\u00E5ndskive0"); 
        icdToL86.add("dm512 - Anden form for torakolumbal diskusprolaps0"); icdToL86.add("dm511 - Lumbal eller torakal diskusprolaps med radikulopati0"); 
        icdToL86.add("dm472 - Anden spondylose med radikulopati0"); icdToL86.add("dm471 - Anden spondylose med myelopati0"); 
        icdToL86.add("dg558 - Kompression af nerverod eller nerveplexus ved anden sygdom klassificeret andetsteds0"); 
        icdToL86.add("dg553 - Kompression af nerverod eller nerveplexus ved anden ryglidelse0"); 
        icdToL86.add("dg552 - Kompression af nerverod eller nerveplexus ved spondylose0"); 
        icdToL86.add("dg551 - Kompression af nerverod eller nerveplexus ved diskuslidelse i rygs\u00F8jlen0"); 
        icdToL86.add("dg550 - Kompression af nerverod eller nerveplexus ved neoplastisk sygdom0"); 
        icdToL86.add("dm510 - Lumbal eller torakal diskusprolaps med myelopati0"); icdToL86.add("dm519 - Sygdom i lumbal eller torakal b\u00E5ndskive UNS"); 

        List<String> icdToL87 = new ArrayList<String>();
        icdToL87.add("dm723 - HER MANGLER EN DIAGNOSTEKST0"); icdToL87.add("dm764 - Tibial kollateral bursitis0"); 
        icdToL87.add("dm763 - Pes anserinus-syndrom0"); icdToL87.add("dm762 - Calcar cristae iliacae0"); 
        icdToL87.add("dm761 - Tendinitis iliopsoas0"); icdToL87.add("dm760 - Tendinitis glutealis0"); 
        icdToL87.add("dm729 - Fibroblastsygdom UNS0"); icdToL87.add("dm728 - Anden fibroblastsygdom0"); 
        icdToL87.add("dm724 - Pseudosarkomat\u00F8s fibromatose0"); icdToL87.add("dm765 - Tendinitis patellaris0"); 
        icdToL87.add("dm725 - HER MANGLER EN DIAGNOSETEKST0"); icdToL87.add("dm766 - Achilles tendinitis0"); 
        icdToL87.add("dm767 - Tendinitis peronealis0"); icdToL87.add("dm768 - Anden entesopati p\u00E5 underekstremitet0"); 
        icdToL87.add("dm769 - Entesopati p\u00E5 underekstremitet UNS0"); icdToL87.add("dm770 - Epicondylitis medialis0"); 
        icdToL87.add("dm772 - Periartritis i h\u00E5ndled0"); icdToL87.add("dm773 - H\u00E6lspore0"); 
        icdToL87.add("dm775 - Anden entesopati p\u00E5 fod0"); icdToL87.add("dm722 - Contractura aponeuroseos plantaris0"); 
        icdToL87.add("dm779 - Entesopati UNS0"); icdToL87.add("dm713 - Anden bursacyste0"); 
        icdToL87.add("dm778 - Anden entesopati IKA0"); icdToL87.add("dm702 - Bursitis olecrani0"); 
        icdToL87.add("dm652 - Tendinitis med forkalkning0"); icdToL87.add("dm653 - Springfinger0"); 
        icdToL87.add("dm654 - Tenovaginitis styloideae radii0"); icdToL87.add("dm658 - Anden form for synovitis eller tenosynovitis0"); 
        icdToL87.add("dm659 - Synovitis eller tenosynovitis UNS0"); icdToL87.add("dm673 - Forbig\u00E5ende synovitis0"); 
        icdToL87.add("dm674 - Ganglion0"); icdToL87.add("dm715 - Anden bursitis IKA0"); 
        icdToL87.add("dm701 - Bursitis i h\u00E5nd0"); icdToL87.add("dm721 - Knofortykkelse0"); 
        icdToL87.add("dm703 - Anden bursitis i albue0"); icdToL87.add("dm704 - Bursitis i slims\u00E6kken over kn\u00E6skallen0"); 
        icdToL87.add("dm718 - Anden sygdom i slims\u00E6k0"); icdToL87.add("dm700 - Kronisk krepiterende synovitis i h\u00E5nd eller h\u00E5ndled0"); 
        icdToL87.add("dm719 - Sygdom i slims\u00E6k UNS0"); icdToL87.add("dm705 - Anden bursitis i kn\u00E60"); 
        icdToL87.add("dm714 - Bursitis med forkalkning0"); icdToL87.add("dm712 - Synovialcyste i kn\u00E6hase0"); 
        icdToL87.add("dm709 - Bl\u00F8ddelsgigt UNS opst\u00E5et ved belastning, overbelastning eller tryk0"); 
        icdToL87.add("dm708 - Anden bl\u00F8ddelsgigt opst\u00E5et ved belastning, overbelastning eller tryk0"); 
        icdToL87.add("dm707 - Anden bursitis i hofte0"); icdToL87.add("dm706 - Bursitis trochanterica0"); 
        icdToL87.add("dm720 - Dupuytrens kontraktur"); 

        List<String> icdToL88 = new ArrayList<String>();
        icdToL88.add("dm088 - Anden form for juvenil artritis0"); icdToL88.add("dm068 - Anden form for reumatoid artritis0"); 
        icdToL88.add("dm089 - Juvenil artritis UNS0"); icdToL88.add("dm084 - Pauciartikul\u00E6r juvenil artritis0"); 
        icdToL88.add("dm083 - Juvenil seronegativ polyartritis0"); icdToL88.add("dm082 - Juvenil artritis med ekstra-artikul\u00E6re manifestationer0"); 
        icdToL88.add("dm081 - Juvenil ankyloserende spondylitis0"); icdToL88.add("dm080 - Juvenil reumatoid artritis0"); 
        icdToL88.add("dm069 - Reumatoid artritis UNS0"); icdToL88.add("dm053 - Reumatoid artritis med involvering af andre organsystemer0"); 
        icdToL88.add("dm459 - Ankyloserende spondylitis0"); icdToL88.add("dm064 - Polyarthritis inflammatorica0"); 
        icdToL88.add("dm051 - Reumatoid artritis med lungemanifestationer0"); icdToL88.add("dm050 - Feltys syndrom0"); 
        icdToL88.add("dm058 - Anden form for seropositiv reumatoid artritis0"); icdToL88.add("dm059 - Seropositiv reumatoid artritis UNS0"); 
        icdToL88.add("dm060 - Seronegativ reumatoid artritis0"); icdToL88.add("dm061 - Stills sygdom med debut efter det fyldte 16. \u00E5r0"); 
        icdToL88.add("dm062 - Bursitis rheumatoides0"); icdToL88.add("dm063 - Noduli rheumatici0"); icdToL88.add("dm052 - Reumatoid vaskulitis");

        List<String> icdToL89 = new ArrayList<String>();
        icdToL89.add("dm167 - Anden form for sekund\u00E6r enkeltsidig hofteledsartrose0"); icdToL89.add("dm165 - Posttraumatisk enkeltsidig hofteledsartrose0"); 
        icdToL89.add("dm169 - Hofteledsartrose UNS0"); icdToL89.add("dm166 - Anden form for sekund\u00E6r dobbeltsidig hofteledsartrose0"); 
        icdToL89.add("dm161 - Prim\u00E6r enkeltsidig hofteledsartrose0"); icdToL89.add("dm163 - Dysplastisk enkeltsidig hofteledsartrose0"); 
        icdToL89.add("dm160 - Prim\u00E6r dobbeltsidig hofteledsartrose0"); icdToL89.add("dm162 - Dysplastisk dobbeltsidig hofteledsartrose0"); 
        icdToL89.add("dm164 - Posttraumatisk dobbeltsidig hofteledsartrose"); 

        List<String> icdToL90 = new ArrayList<String>();
        icdToL90.add("dm170 - Prim\u00E6r dobbeltsidig kn\u00E6ledsartrose0"); icdToL90.add("dm179 - Kn\u00E6ledsartrose UNS0"); 
        icdToL90.add("dm175 - Anden form for sekund\u00E6r enkeltsidig kn\u00E6ledsartrose0"); 
        icdToL90.add("dm174 - Anden form for sekund\u00E6r bilateral kn\u00E6ledsartrose0"); 
        icdToL90.add("dm173 - Posttraumatisk enkeltsidig kn\u00E6ledsartrose0"); icdToL90.add("dm172 - Posttraumatisk dobbeltsidig kn\u00E6ledsartrose0"); 
        icdToL90.add("dm171 - Prim\u00E6r enkeltsidig kn\u00E6ledsartrose"); 

        List<String> icdToL91 = new ArrayList<String>();
        icdToL91.add("dm181 - Prim\u00E6r enkeltsidig artrose i tommelfingers rodled0"); icdToL91.add("dm192 - Anden sekund\u00E6r artrose i andet (andre) led0"); 
        icdToL91.add("dm191 - Posttraumatisk artrose i andet (andre) led0"); icdToL91.add("dm190 - Prim\u00E6r artrose i andet (andre) led0"); 
        icdToL91.add("dm189 - Artrose i tommelfingers rodled UNS0"); icdToL91.add("dm185 - Anden form for sekund\u00E6r enkeltsidig artrose i tommelfingers rodled0"); 
        icdToL91.add("dm184 - Anden form for sekund\u00E6r bilateral artrose i tommelfingers rodled0"); 
        icdToL91.add("dm183 - Posttraumatisk enkeltsidig artrose i tommelfingers rodled0"); 
        icdToL91.add("dm182 - Posttraumatisk dobbeltsidig artrose i tommelfingers rodled0"); icdToL91.add("dm199 - Artrose UNS0"); 
        icdToL91.add("dm150 - Prim\u00E6r generaliseret artrose0"); icdToL91.add("dm180 - Prim\u00E6r dobbeltsidig artrose i tommelfingers rodled0"); 
        icdToL91.add("dm198 - Anden artrose0"); icdToL91.add("dm130 - Polyartritis UNS0"); icdToL91.add("dm131 - Monoartritis IKA0"); 
        icdToL91.add("dm139 - Artritis UNS0"); icdToL91.add("dm151 - Heberdens knuder ved artrose0"); icdToL91.add("dm152 - Bouchards knuder ved artrose0"); 
        icdToL91.add("dm153 - Sekund\u00E6r multipel artrose0"); icdToL91.add("dm154 - Erosiv artrose0"); icdToL91.add("dm158 - Anden polyartrose0"); 
        icdToL91.add("dm159 - Polyartrose UNS0"); icdToL91.add("dm138 - Anden artritis"); 

        List<String> icdToL92 = new ArrayList<String>();
        icdToL92.add("dm754 - Afklemningssyndrom i skulder0"); icdToL92.add("dm755 - Bursitis i skulder0"); 
        icdToL92.add("dm759 - Skulderlidelse UNS0"); icdToL92.add("dm753 - Tendinitis med forkalkning i skulderen0");
        icdToL92.add("dm752 - Bicepstendinitis0"); icdToL92.add("dm750 - Periarthrosis humeroscapularis0");
        icdToL92.add("dm751 - Rotator cuff-syndrom0"); icdToL92.add("dm758 - Anden skulderlidelse");

        List<String> icdToL93 = new ArrayList<String>();
        icdToL93.add("dm771 - Epicondylitis lateralis");

        List<String> icdToL94 = new ArrayList<String>();
        icdToL94.add("dm931 - Osteokondrose i os lunatum hos voksen0"); icdToL94.add("dm925 - Juvenil osteokondrose i underben0"); 
        icdToL94.add("dm926 - Juvenil osteokondrose i fodrod0"); icdToL94.add("dm927 - Juvenil osteokondrose i mellemfod0"); 
        icdToL94.add("dm928 - Anden juvenil brusklidelse0"); icdToL94.add("dm930 - Juvenil ikke-traumatisk hofteepifysiolyse0"); 
        icdToL94.add("dm913 - Pseudocoxalgia0"); icdToL94.add("dm932 - Osteochondritis dissecans0"); 
        icdToL94.add("dm938 - Anden osteokondropati0"); icdToL94.add("dm939 - Osteokondropati UNS0"); 
        icdToL94.add("dm924 - Juvenil osteokondrose i kn\u00E6skal0"); icdToL94.add("dm929 - Juvenil brusklidelse UNS0"); 
        icdToL94.add("dm910 - Juvenil b\u00E6kkenosteokondrose0"); icdToL94.add("dm919 - Juvenil brusklidelse i hofte eller b\u00E6kken UNS0"); 
        icdToL94.add("dm923 - Anden juvenil osteokondrose i overekstremitet0"); icdToL94.add("dm429 - Osteokondrose i rygs\u00F8jlen UNS0"); 
        icdToL94.add("dm420 - Juvenil osteokondrose i rygs\u00F8jlen0"); icdToL94.add("dm911 - Juvenil deformerende hofteosteokondrose0"); 
        icdToL94.add("dm912 - Coxa plana0"); icdToL94.add("dm918 - Anden form for juvenil brusklidelse i hofte eller b\u00E6kken0"); 
        icdToL94.add("dm920 - Juvenil osteokondrose i overarm0"); icdToL94.add("dm921 - Juvenil osteokondrose i underarm0"); 
        icdToL94.add("dm922 - Juvenil osteokondrose i h\u00E5nd0"); icdToL94.add("dm421 - Adult osteokondrose i rygs\u00F8jlen"); 

        List<String> icdToL95 = new ArrayList<String>();
        icdToL95.add("dm818 - Anden osteoporose0"); icdToL95.add("dm814 - Osteoporose for\u00E5rsaget af l\u00E6gemiddel0"); 
        icdToL95.add("dm815 - Idiopatisk osteoporose0"); icdToL95.add("dm816 - Lokaliseret osteoporose0"); 
        icdToL95.add("dm819 - Osteoporose UNS0"); icdToL95.add("dm820 - Osteoporose ved myelomatose0"); 
        icdToL95.add("dm821 - Osteoporose ved endokrin sygdom0"); icdToL95.add("dm828 - Osteoporose ved andre sygdomme klassificeret andetsteds0"); 
        icdToL95.add("dm813 - Osteoporose for\u00E5rsaget af malabsorption efter operation0"); icdToL95.add("dm808 - Anden form for osteoporose med patologisk fraktur0"); 
        icdToL95.add("dm800 - Postmenopausal osteoporose med patologisk fraktur0"); icdToL95.add("dm811 - Osteoporose efter ooforektomi0"); 
        icdToL95.add("dm812 - Immobilisationsosteoporose0"); icdToL95.add("dm809 - Osteoporose UNS med patologisk fraktur0"); 
        icdToL95.add("dm810 - Postmenopausal osteoporose0"); icdToL95.add("dm805 - Idiopatisk osteoporose med patologisk fraktur0"); 
        icdToL95.add("dm804 - Osteoporose med patologisk fraktur for\u00E5rsaget af l\u00E6gemiddel0"); 
        icdToL95.add("dm803 - Osteoporose med patologisk fraktur for\u00E5rsaget af malabsorption efter operation0"); 
        icdToL95.add("dm802 - Immobilisationsosteoporose med patologisk fraktur0"); icdToL95.add("dm801 - Osteoporose efter ooforektomi med patologisk fraktur"); 

        List<String> icdToL96 = new ArrayList<String>();
        icdToL96.add("ds835 - L\u00E6sion af korsb\u00E5nd i kn\u00E6led0"); icdToL96.add("ds833 - Fraktur af ledbrusk i kn\u00E6led0"); 
        icdToL96.add("ds832 - Traumatisk ruptur af menisk i kn\u00E6led0"); icdToL96.add("ds837 - Multiple l\u00E6sioner af strukturer i kn\u00E6led"); 

        List<String> icdToL97 = new ArrayList<String>();
        icdToL97.add("dd167 - Godartet tumor i knogle eller ledbrusk i ribben, brystben eller clavicula0"); 
        icdToL97.add("dd212 - Godartet tumor i bindev\u00E6v i underekstremitet0"); icdToL97.add("dd481 - Ikke specificeret tumor i bindev\u00E6v eller andre bl\u00F8ddele0"); 
        icdToL97.add("dd480 - Ikke specificeret tumor i knogle eller ledbrusk0"); icdToL97.add("dd219 - Godartet tumor i bindev\u00E6v UNS0"); 
        icdToL97.add("dd217 - Godartet tumor i bindev\u00E6v med anden lokalisation0"); icdToL97.add("dd216 - Godartet tumor i bindev\u00E6v i kroppen UNS0"); 
        icdToL97.add("dd215 - Godartet tumor i bindev\u00E6v i b\u00E6kkenet0"); icdToL97.add("dd214 - Godartet tumor i bindev\u00E6v i abdomen0"); 
        icdToL97.add("dd213 - Godartet tumor i bindev\u00E6v i thorax0"); icdToL97.add("dd163 - Godartet tumor i knogle eller ledbrusk i kort knogle i underekstremitet0"); 
        icdToL97.add("dd160 - Godartet tumor i knogle eller ledbrusk i skulderblad eller lang knogle i overekstremitet0"); 
        icdToL97.add("dd169 - Godartet tumor i knogle eller ledbrusk UNS0"); 
        icdToL97.add("dd162 - Godartet tumor i knogle eller ledbrusk i lang knogle i underekstremitet0"); 
        icdToL97.add("dd211 - Godartet tumor i bindev\u00E6v i overekstremitet0"); 
        icdToL97.add("dd164 - Godartet tumor i knogle eller ledbrusk i kranie eller ansigt0"); 
        icdToL97.add("dd165 - Godartet tumor i knogle eller ledbrusk i underk\u00E6ben0"); 
        icdToL97.add("dd166 - Godartet tumor i knogle eller ledbrusk i rygs\u00F8jlen0"); 
        icdToL97.add("dd168 - Godartet tumor i knogle eller ledbrusk i b\u00E6kken, os sacrum eller os coccygis0"); 
        icdToL97.add("dd210 - Godartet tumor i bindev\u00E6v eller andre bl\u00F8ddele i hoved, ansigt eller hals0"); 
        icdToL97.add("dd161 - Godartet tumor i knogle eller ledbrusk i kort knogle i overekstremitet"); 

        List<String> icdToL98 = new ArrayList<String>();
        icdToL98.add("dm204 - Hammert\u00E5 UNS0"); icdToL98.add("dm213 - Erhvervet dropfod0"); 
        icdToL98.add("dm219 - Erhvervet ekstremitetsdeformitet UNS0"); icdToL98.add("dm218 - Anden erhvervet ekstremitetsdeformitet0"); 
        icdToL98.add("dm217 - Erhvervet anisomeli0"); icdToL98.add("dm216 - Anden erhvervet deformitet af ankel eller fod0"); 
        icdToL98.add("dm215 - Erhvervet kloh\u00E5nd, klofod, klumph\u00E5nd eller klumpfod0"); icdToL98.add("dm214 - Erhvervet platfod0"); 
        icdToL98.add("dm211 - Varusdeformitet IKA0"); icdToL98.add("dm210 - Valgusdeformitet IKA0"); 
        icdToL98.add("dm205 - Anden erhvervet deformitet af t\u00E50"); icdToL98.add("dm203 - Anden erhvervet deformitet af storet\u00E50"); 
        icdToL98.add("dm202 - Hallux rigidus0"); icdToL98.add("dm201 - Erhvervet hallux valgus0"); 
        icdToL98.add("dm200 - Deformitet af fingre0"); icdToL98.add("dm206 - Erhvervet t\u00E5deformitet UNS0"); icdToL98.add("dm212 - Fleksionsdeformitet"); 

        List<String> icdToL99 = new ArrayList<String>();
        icdToL99.add("dm840"); icdToL99.add("dm850"); icdToL99.add("dm849"); icdToL99.add("dm848"); icdToL99.add("dm844"); icdToL99.add("dm843"); 
        icdToL99.add("dm842"); icdToL99.add("dm851"); icdToL99.add("dm880"); icdToL99.add("dm858"); icdToL99.add("dm888"); icdToL99.add("dm798"); 
        icdToL99.add("dm841"); icdToL99.add("dm852"); icdToL99.add("dm853"); icdToL99.add("dm854"); icdToL99.add("dm856"); icdToL99.add("dm859"); 
        icdToL99.add("dm870"); icdToL99.add("dm871"); icdToL99.add("dm872"); icdToL99.add("dm873"); icdToL99.add("dm878"); icdToL99.add("dm879"); 
        icdToL99.add("dm794"); icdToL99.add("dm855"); icdToL99.add("dm662"); icdToL99.add("dm621"); icdToL99.add("dm622"); icdToL99.add("dm952"); 
        icdToL99.add("dm623"); icdToL99.add("dm889"); icdToL99.add("dm628"); icdToL99.add("dm629"); icdToL99.add("dm630"); icdToL99.add("dm631"); 
        icdToL99.add("dm632"); icdToL99.add("dm633"); icdToL99.add("dm638"); icdToL99.add("dm624"); icdToL99.add("dm661"); icdToL99.add("dm738"); 
        icdToL99.add("dm663"); icdToL99.add("dm664"); icdToL99.add("dm665"); icdToL99.add("dm670"); icdToL99.add("dm671"); icdToL99.add("dm672"); 
        icdToL99.add("dm678"); icdToL99.add("dm679"); icdToL99.add("dm680"); icdToL99.add("dm688"); icdToL99.add("dm730"); icdToL99.add("dm731"); 
        icdToL99.add("dm660"); icdToL99.add("dz891"); icdToL99.add("dm959"); icdToL99.add("dm990"); icdToL99.add("dm991"); icdToL99.add("dm992"); 
        icdToL99.add("dm993"); icdToL99.add("dm994"); icdToL99.add("dm995"); icdToL99.add("dm996"); icdToL99.add("dm997"); icdToL99.add("dm998"); 
        icdToL99.add("dm999"); icdToL99.add("dm950"); icdToL99.add("dz890"); icdToL99.add("dm954"); icdToL99.add("dz892"); icdToL99.add("dz893"); 
        icdToL99.add("dz894"); icdToL99.add("dz895"); icdToL99.add("dz896"); icdToL99.add("dz897"); icdToL99.add("dz898"); icdToL99.add("dz899"); 
        icdToL99.add("dz981"); icdToL99.add("dm257"); icdToL99.add("dm620"); icdToL99.add("dt796"); icdToL99.add("dm905"); icdToL99.add("dm891"); 
        icdToL99.add("dm892"); icdToL99.add("dm893"); icdToL99.add("dm894"); icdToL99.add("dm895"); icdToL99.add("dm896"); icdToL99.add("dm898"); 
        icdToL99.add("dm899"); icdToL99.add("dm900"); icdToL99.add("dm901"); icdToL99.add("dm902"); icdToL99.add("dm958"); icdToL99.add("dm904"); 
        icdToL99.add("dm955"); icdToL99.add("dm906"); icdToL99.add("dm907"); icdToL99.add("dm908"); icdToL99.add("dm940"); icdToL99.add("dm941"); 
        icdToL99.add("dm942"); icdToL99.add("dm943"); icdToL99.add("dm948"); icdToL99.add("dm949"); icdToL99.add("dm951"); icdToL99.add("dm953"); 
        icdToL99.add("dm890"); icdToL99.add("dm903"); icdToL99.add("dm231"); icdToL99.add("dm141"); icdToL99.add("dm142"); icdToL99.add("dm143"); 
        icdToL99.add("dm144"); icdToL99.add("dm145"); icdToL99.add("dm146"); icdToL99.add("dm148"); icdToL99.add("dm222"); icdToL99.add("dm223"); 
        icdToL99.add("dm224"); icdToL99.add("dm228"); icdToL99.add("dm245"); icdToL99.add("dm230"); icdToL99.add("dm125"); icdToL99.add("dm232"); 
        icdToL99.add("dm233"); icdToL99.add("dm234"); icdToL99.add("dm235"); icdToL99.add("dm236"); icdToL99.add("dm238"); icdToL99.add("dm239"); 
        icdToL99.add("dm259"); icdToL99.add("dm241"); icdToL99.add("dm243"); icdToL99.add("dm244"); icdToL99.add("dm229"); icdToL99.add("dm074"); 
        icdToL99.add("dm619"); icdToL99.add("dm022"); icdToL99.add("dm023"); icdToL99.add("dm028"); icdToL99.add("dm029"); icdToL99.add("dm030"); 
        icdToL99.add("dm031"); icdToL99.add("dm032"); icdToL99.add("dm036"); icdToL99.add("dm070"); icdToL99.add("dm071"); icdToL99.add("dm140"); 
        icdToL99.add("dm073"); icdToL99.add("dm128"); icdToL99.add("dm075"); icdToL99.add("dm076"); icdToL99.add("dm090"); icdToL99.add("dm091"); 
        icdToL99.add("dm092"); icdToL99.add("dm098"); icdToL99.add("dm120"); icdToL99.add("dm121"); icdToL99.add("dm122"); icdToL99.add("dm123"); 
        icdToL99.add("dm124"); icdToL99.add("dm242"); icdToL99.add("dm072"); icdToL99.add("dm491"); icdToL99.add("dm355"); icdToL99.add("dm356"); 
        icdToL99.add("dm246"); icdToL99.add("dm358"); icdToL99.add("dm240"); icdToL99.add("dm360"); icdToL99.add("dm361"); icdToL99.add("dm362"); 
        icdToL99.add("dm363"); icdToL99.add("dm364"); icdToL99.add("dm368"); icdToL99.add("dm354"); icdToL99.add("dm490"); icdToL99.add("dm357"); 
        icdToL99.add("dm492"); icdToL99.add("dm493"); icdToL99.add("dm494"); icdToL99.add("dm495"); icdToL99.add("dm498"); icdToL99.add("dm541"); 
        icdToL99.add("dm610"); icdToL99.add("dm611"); icdToL99.add("dm612"); icdToL99.add("dm613"); icdToL99.add("dm614"); icdToL99.add("dm615"); 
        icdToL99.add("dm432"); icdToL99.add("dm258"); icdToL99.add("dm247"); icdToL99.add("dm248"); icdToL99.add("dm249"); icdToL99.add("dm250"); 
        icdToL99.add("dm251"); icdToL99.add("dm252"); icdToL99.add("dm359"); icdToL99.add("dm021"); icdToL99.add("dm353"); icdToL99.add("dm020"); 
        icdToL99.add("dm320"); icdToL99.add("dm321"); icdToL99.add("dm328"); icdToL99.add("dm350"); icdToL99.add("dm352"); icdToL99.add("dm253"); 
        icdToL99.add("dm351"); icdToL99.add("dm329"); icdToL99.add("dm349"); icdToL99.add("dm348"); icdToL99.add("dm341"); icdToL99.add("dm340"); 
        icdToL99.add("dm330"); icdToL99.add("dm339"); icdToL99.add("dm332"); icdToL99.add("dm331"); icdToL99.add("dm342");



        // ICPC-2-dk koden sættes som key (i " ") og values sættes som de forud indtastede lister.  

        // NewMap.put("L70",icdToL80);
        // NewMap.put("L71",icdToL81);
        // NewMap.put("L72",icdToL82);
        // NewMap.put("L73",icdToL83);
        // NewMap.put("L74",icdToL84);
        // NewMap.put("L75",icdToL85);
        // NewMap.put("L76",icdToL86);
        // NewMap.put("L77",icdToL87);
        // NewMap.put("L78",icdToL88);
        // NewMap.put("L79",icdToL89);
        // NewMap.put("L80",icdToL80);
        // NewMap.put("L81",icdToL81);
        // NewMap.put("L82",icdToL82);
        // NewMap.put("L83",icdToL83);
        // NewMap.put("L84",icdToL84);
        // NewMap.put("L85",icdToL85);
        NewMap.put("L86",icdToL86);
        NewMap.put("L87",icdToL87);
        NewMap.put("L88",icdToL88);
        NewMap.put("L89",icdToL89);
        NewMap.put("L90",icdToL90);
        NewMap.put("L91",icdToL91);
        NewMap.put("L92",icdToL92);
        NewMap.put("L93",icdToL93);
        NewMap.put("L94",icdToL94);
        NewMap.put("L95",icdToL95);
        NewMap.put("L96",icdToL96);
        NewMap.put("L97",icdToL97);
        NewMap.put("L98",icdToL98);
        // NewMap.put("L99",icdToL99);

        return NewMap;
    }

}

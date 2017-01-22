package com.hadoop.project.Mapper;

import com.hadoop.project.Counters.Counters;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by marti on 22/01/2017.
 *
 * random text generator mapper
 */
public class RandomDataGeneratorMapper extends Mapper<Text, Text, Text, Text> {

    /**
     * A random list of 100 words
     */
    private static String[] words = {
            "diurnalness", "Homoiousian",
            "spiranthic", "tetragynian",
            "silverhead", "ungreat",
            "lithograph", "exploiter",
            "physiologian", "by",
            "hellbender", "Filipendula",
            "undeterring", "antiscolic",
            "pentagamist", "hypoid",
            "cacuminal", "sertularian",
            "schoolmasterism", "nonuple",
            "gallybeggar", "phytonic",
            "swearingly", "nebular",
            "Confervales", "thermochemically",
            "characinoid", "cocksuredom",
            "fallacious", "feasibleness",
            "debromination", "playfellowship",
            "tramplike", "testa",
            "participatingly", "unaccessible",
            "bromate", "experientialist",
            "roughcast", "docimastical",
            "choralcelo", "blightbird",
            "peptonate", "sombreroed",
            "unschematized", "antiabolitionist",
            "besagne", "mastication",
            "bromic", "sviatonosite",
            "cattimandoo", "metaphrastical",
            "endotheliomyoma", "hysterolysis",
            "unfulminated", "Hester",
            "oblongly", "blurredness",
            "authorling", "chasmy",
            "Scorpaenidae", "toxihaemia",
            "Dictograph", "Quakerishly",
            "deaf", "timbermonger",
            "strammel", "Thraupidae",
            "seditious", "plerome",
            "Arneb", "eristically",
            "serpentinic", "glaumrie",
            "socioromantic", "apocalypst",
            "tartrous", "Bassaris",
            "angiolymphoma", "horsefly",
            "kenno", "astronomize",
            "euphemious", "arsenide",
            "untongued", "parabolicness",
            "uvanite", "helpless",
            "gemmeous", "stormy",
            "templar", "erythrodextrin",
            "comism", "interfraternal",
            "preparative", "parastas",
            "frontoorbital", "Ophiosaurus",
            "diopside", "serosanguineous",
            "ununiformly", "karyological",
            "collegian", "allotropic",
            "depravity", "amylogenesis",
            "reformatory", "epidymides",
            "pleurotropous", "trillium",
            "dastardliness", "coadvice",
            "embryotic", "benthonic",
            "pomiferous", "figureheadship",
            "Megaluridae", "Harpa",
            "frenal", "commotion",
            "abthainry", "cobeliever",
            "manilla", "spiciferous",
            "nativeness", "obispo",
            "monilioid", "biopsic",
            "valvula", "enterostomy",
            "planosubulate", "pterostigma",
            "lifter", "triradiated",
            "venialness", "tum",
            "archistome", "tautness",
            "unswanlike", "antivenin",
            "Lentibulariaceae", "Triphora",
            "angiopathy", "anta",
            "Dawsonia", "becomma",
            "Yannigan", "winterproof",
            "antalgol", "harr",
            "underogating", "ineunt",
            "cornberry", "flippantness",
            "scyphostoma", "approbation",
            "Ghent", "Macraucheniidae",
            "scabbiness", "unanatomized",
            "photoelasticity", "eurythermal",
            "enation", "prepavement",
            "flushgate", "subsequentially",
            "Edo", "antihero",
            "Isokontae", "unforkedness",
            "porriginous", "daytime",
            "nonexecutive", "trisilicic",
            "morphiomania", "paranephros",
            "botchedly", "impugnation",
            "Dodecatheon", "obolus",
            "unburnt", "provedore",
            "Aktistetae", "superindifference",
            "Alethea", "Joachimite",
            "cyanophilous", "chorograph",
            "brooky", "figured",
            "periclitation", "quintette",
            "hondo", "ornithodelphous",
            "unefficient", "pondside",
            "bogydom", "laurinoxylon",
            "Shiah", "unharmed",
            "cartful", "noncrystallized",
            "abusiveness", "cromlech",
            "japanned", "rizzomed",
            "underskin", "adscendent",
            "allectory", "gelatinousness",
            "volcano", "uncompromisingly",
            "cubit", "idiotize",
            "unfurbelowed", "undinted",
            "magnetooptics", "Savitar",
            "diwata", "ramosopalmate",
            "Pishquow", "tomorn",
            "apopenptic", "Haversian",
            "Hysterocarpus", "ten",
            "outhue", "Bertat",
            "mechanist", "asparaginic",
            "velaric", "tonsure",
            "bubble", "Pyrales",
            "regardful", "glyphography",
            "calabazilla", "shellworker",
            "stradametrical", "havoc",
            "theologicopolitical", "sawdust",
            "diatomaceous", "jajman",
            "temporomastoid", "Serrifera",
            "Ochnaceae", "aspersor",
            "trailmaking", "Bishareen",
            "digitule", "octogynous",
            "epididymitis", "smokefarthings",
            "bacillite", "overcrown",
            "mangonism", "sirrah",
            "undecorated", "psychofugal",
            "bismuthiferous", "rechar",
            "Lemuridae", "frameable",
            "thiodiazole", "Scanic",
            "sportswomanship", "interruptedness",
            "admissory", "osteopaedion",
            "tingly", "tomorrowness",
            "ethnocracy", "trabecular",
            "vitally", "fossilism",
            "adz", "metopon",
            "prefatorial", "expiscate",
            "diathermacy", "chronist",
            "nigh", "generalizable",
            "hysterogen", "aurothiosulphuric",
            "whitlowwort", "downthrust",
            "Protestantize", "monander",
            "Itea", "chronographic",
            "silicize", "Dunlop",
            "eer", "componental",
            "spot", "pamphlet",
            "antineuritic", "paradisean",
            "interruptor", "debellator",
            "overcultured", "Florissant",
            "hyocholic", "pneumatotherapy",
            "tailoress", "rave",
            "unpeople", "Sebastian",
            "thermanesthesia", "Coniferae",
            "swacking", "posterishness",
            "ethmopalatal", "whittle",
            "analgize", "scabbardless",
            "naught", "symbiogenetically",
            "trip", "parodist",
            "columniform", "trunnel",
            "yawler", "goodwill",
            "pseudohalogen", "swangy",
            "cervisial", "mediateness",
            "genii", "imprescribable",
            "pony", "consumptional",
            "carposporangial", "poleax",
            "bestill", "subfebrile",
            "sapphiric", "arrowworm",
            "qualminess", "ultraobscure",
            "thorite", "Fouquieria",
            "Bermudian", "prescriber",
            "elemicin", "warlike",
            "semiangle", "rotular",
            "misthread", "returnability",
            "seraphism", "precostal",
            "quarried", "Babylonism",
            "sangaree", "seelful",
            "placatory", "pachydermous",
            "bozal", "galbulus",
            "spermaphyte", "cumbrousness",
            "pope", "signifier",
            "Endomycetaceae", "shallowish",
            "sequacity", "periarthritis",
            "bathysphere", "pentosuria",
            "Dadaism", "spookdom",
            "Consolamentum", "afterpressure",
            "mutter", "louse",
            "ovoviviparous", "corbel",
            "metastoma", "biventer",
            "Hydrangea", "hogmace",
            "seizing", "nonsuppressed",
            "oratorize", "uncarefully",
            "benzothiofuran", "penult",
            "balanocele", "macropterous",
            "dishpan", "marten",
            "absvolt", "jirble",
            "parmelioid", "airfreighter",
            "acocotl", "archesporial",
            "hypoplastral", "preoral",
            "quailberry", "cinque",
            "terrestrially", "stroking",
            "limpet", "moodishness",
            "canicule", "archididascalian",
            "pompiloid", "overstaid",
            "introducer", "Italical",
            "Christianopaganism", "prescriptible",
            "subofficer", "danseuse",
            "cloy", "saguran",
            "frictionlessly", "deindividualization",
            "Bulanda", "ventricous",
            "subfoliar", "basto",
            "scapuloradial", "suspend",
            "stiffish", "Sphenodontidae",
            "eternal", "verbid",
            "mammonish", "upcushion",
            "barkometer", "concretion",
            "preagitate", "incomprehensible",
            "tristich", "visceral",
            "hemimelus", "patroller",
            "stentorophonic", "pinulus",
            "kerykeion", "brutism",
            "monstership", "merciful",
            "overinstruct", "defensibly",
            "bettermost", "splenauxe",
            "Mormyrus", "unreprimanded",
            "taver", "ell",
            "proacquittal", "infestation",
            "overwoven", "Lincolnlike",
            "chacona", "Tamil",
            "classificational", "lebensraum",
            "reeveland", "intuition",
            "Whilkut", "focaloid",
            "Eleusinian", "micromembrane",
            "byroad", "nonrepetition",
            "bacterioblast", "brag",
            "ribaldrous", "phytoma",
            "counteralliance", "pelvimetry",
            "pelf", "relaster",
            "thermoresistant", "aneurism",
            "molossic", "euphonym",
            "upswell", "ladhood",
            "phallaceous", "inertly",
            "gunshop", "stereotypography",
            "laryngic", "refasten",
            "twinling", "oflete",
            "hepatorrhaphy", "electrotechnics",
            "cockal", "guitarist",
            "topsail", "Cimmerianism",
            "larklike", "Llandovery",
            "pyrocatechol", "immatchable",
            "chooser", "metrocratic",
            "craglike", "quadrennial",
            "nonpoisonous", "undercolored",
            "knob", "ultratense",
            "balladmonger", "slait",
            "sialadenitis", "bucketer",
            "magnificently", "unstipulated",
            "unscourged", "unsupercilious",
            "packsack", "pansophism",
            "soorkee", "percent",
            "subirrigate", "champer",
            "metapolitics", "spherulitic",
            "involatile", "metaphonical",
            "stachyuraceous", "speckedness",
            "bespin", "proboscidiform",
            "gul", "squit",
            "yeelaman", "peristeropode",
            "opacousness", "shibuichi",
            "retinize", "yote",
            "misexposition", "devilwise",
            "pumpkinification", "vinny",
            "bonze", "glossing",
            "decardinalize", "transcortical",
            "serphoid", "deepmost",
            "guanajuatite", "wemless",
            "arval", "lammy",
            "Effie", "Saponaria",
            "tetrahedral", "prolificy",
            "excerpt", "dunkadoo",
            "Spencerism", "insatiately",
            "Gilaki", "oratorship",
            "arduousness", "unbashfulness",
            "Pithecolobium", "unisexuality",
            "veterinarian", "detractive",
            "liquidity", "acidophile",
            "proauction", "sural",
            "totaquina", "Vichyite",
            "uninhabitedness", "allegedly",
            "Gothish", "manny",
            "Inger", "flutist",
            "ticktick", "Ludgatian",
            "homotransplant", "orthopedical",
            "diminutively", "monogoneutic",
            "Kenipsim", "sarcologist",
            "drome", "stronghearted",
            "Fameuse", "Swaziland",
            "alen", "chilblain",
            "beatable", "agglomeratic",
            "constitutor", "tendomucoid",
            "porencephalous", "arteriasis",
            "boser", "tantivy",
            "rede", "lineamental",
            "uncontradictableness", "homeotypical",
            "masa", "folious",
            "dosseret", "neurodegenerative",
            "subtransverse", "Chiasmodontidae",
            "palaeotheriodont", "unstressedly",
            "chalcites", "piquantness",
            "lampyrine", "Aplacentalia",
            "projecting", "elastivity",
            "isopelletierin", "bladderwort",
            "strander", "almud",
            "iniquitously", "theologal",
            "bugre", "chargeably",
            "imperceptivity", "meriquinoidal",
            "mesophyte", "divinator",
            "perfunctory", "counterappellant",
            "synovial", "charioteer",
            "crystallographical", "comprovincial",
            "infrastapedial", "pleasurehood",
            "inventurous", "ultrasystematic",
            "subangulated", "supraoesophageal",
            "Vaishnavism", "transude",
            "chrysochrous", "ungrave",
            "reconciliable", "uninterpleaded",
            "erlking", "wherefrom",
            "aprosopia", "antiadiaphorist",
            "metoxazine", "incalculable",
            "umbellic", "predebit",
            "foursquare", "unimmortal",
            "nonmanufacture", "slangy",
            "predisputant", "familist",
            "preaffiliate", "friarhood",
            "corelysis", "zoonitic",
            "halloo", "paunchy",
            "neuromimesis", "aconitine",
            "hackneyed", "unfeeble",
            "cubby", "autoschediastical",
            "naprapath", "lyrebird",
            "inexistency", "leucophoenicite",
            "ferrogoslarite", "reperuse",
            "uncombable", "tambo",
            "propodiale", "diplomatize",
            "Russifier", "clanned",
            "corona", "michigan",
            "nonutilitarian", "transcorporeal",
            "bought", "Cercosporella",
            "stapedius", "glandularly",
            "pictorially", "weism",
            "disilane", "rainproof",
            "Caphtor", "scrubbed",
            "oinomancy", "pseudoxanthine",
            "nonlustrous", "redesertion",
            "Oryzorictinae", "gala",
            "Mycogone", "reappreciate",
            "cyanoguanidine", "seeingness",
            "breadwinner", "noreast",
            "furacious", "epauliere",
            "omniscribent", "Passiflorales",
            "uninductive", "inductivity",
            "Orbitolina", "Semecarpus",
            "migrainoid", "steprelationship",
            "phlogisticate", "mesymnion",
            "sloped", "edificator",
            "beneficent", "culm",
            "paleornithology", "unurban",
            "throbless", "amplexifoliate",
            "sesquiquintile", "sapience",
            "astucious", "dithery",
            "boor", "ambitus",
            "scotching", "uloid",
            "uncompromisingness", "hoove",
            "waird", "marshiness",
            "Jerusalem", "mericarp",
            "unevoked", "benzoperoxide",
            "outguess", "pyxie",
            "hymnic", "euphemize",
            "mendacity", "erythremia",
            "rosaniline", "unchatteled",
            "lienteria", "Bushongo",
            "dialoguer", "unrepealably",
            "rivethead", "antideflation",
            "vinegarish", "manganosiderite",
            "doubtingness", "ovopyriform",
            "Cephalodiscus", "Muscicapa",
            "Animalivora", "angina",
            "planispheric", "ipomoein",
            "cuproiodargyrite", "sandbox",
            "scrat", "Munnopsidae",
            "shola", "pentafid",
            "overstudiousness", "times",
            "nonprofession", "appetible",
            "valvulotomy", "goladar",
            "uniarticular", "oxyterpene",
            "unlapsing", "omega",
            "trophonema", "seminonflammable",
            "circumzenithal", "starer",
            "depthwise", "liberatress",
            "unleavened", "unrevolting",
            "groundneedle", "topline",
            "wandoo", "umangite",
            "ordinant", "unachievable",
            "oversand", "snare",
            "avengeful", "unexplicit",
            "mustafina", "sonable",
            "rehabilitative", "eulogization",
            "papery", "technopsychology",
            "impressor", "cresylite",
            "entame", "transudatory",
            "scotale", "pachydermatoid",
            "imaginary", "yeat",
            "slipped", "stewardship",
            "adatom", "cockstone",
            "skyshine", "heavenful",
            "comparability", "exprobratory",
            "dermorhynchous", "parquet",
            "cretaceous", "vesperal",
            "raphis", "undangered",
            "Glecoma", "engrain",
            "counteractively", "Zuludom",
            "orchiocatabasis", "Auriculariales",
            "warriorwise", "extraorganismal",
            "overbuilt", "alveolite",
            "tetchy", "terrificness",
            "widdle", "unpremonished",
            "rebilling", "sequestrum",
            "equiconvex", "heliocentricism",
            "catabaptist", "okonite",
            "propheticism", "helminthagogic",
            "calycular", "giantly",
            "wingable", "golem",
            "unprovided", "commandingness",
            "greave", "haply",
            "doina", "depressingly",
            "subdentate", "impairment",
            "decidable", "neurotrophic",
            "unpredict", "bicorporeal",
            "pendulant", "flatman",
            "intrabred", "toplike",
            "Prosobranchiata", "farrantly",
            "toxoplasmosis", "gorilloid",
            "dipsomaniacal", "aquiline",
            "atlantite", "ascitic",
            "perculsive", "prospectiveness",
            "saponaceous", "centrifugalization",
            "dinical", "infravaginal",
            "beadroll", "affaite",
            "Helvidian", "tickleproof",
            "abstractionism", "enhedge",
            "outwealth", "overcontribute",
            "coldfinch", "gymnastic",
            "Pincian", "Munychian",
            "codisjunct", "quad",
            "coracomandibular", "phoenicochroite",
            "amender", "selectivity",
            "putative", "semantician",
            "lophotrichic", "Spatangoidea",
            "saccharogenic", "inferent",
            "Triconodonta", "arrendation",
            "sheepskin", "taurocolla",
            "bunghole", "Machiavel",
            "triakistetrahedral", "dehairer",
            "prezygapophysial", "cylindric",
            "pneumonalgia", "sleigher",
            "emir", "Socraticism",
            "licitness", "massedly",
            "instructiveness", "sturdied",
            "redecrease", "starosta",
            "evictor", "orgiastic",
            "squdge", "meloplasty",
            "Tsonecan", "repealableness",
            "swoony", "myesthesia",
            "molecule", "autobiographist",
            "reciprocation", "refective",
            "unobservantness", "tricae",
            "ungouged", "floatability",
            "Mesua", "fetlocked",
            "chordacentrum", "sedentariness",
            "various", "laubanite",
            "nectopod", "zenick",
            "sequentially", "analgic",
            "biodynamics", "posttraumatic",
            "nummi", "pyroacetic",
            "bot", "redescend",
            "dispermy", "undiffusive",
            "circular", "trillion",
            "Uraniidae", "ploration",
            "discipular", "potentness",
            "sud", "Hu",
            "Eryon", "plugger",
            "subdrainage", "jharal",
            "abscission", "supermarket",
            "countergabion", "glacierist",
            "lithotresis", "minniebush",
            "zanyism", "eucalypteol",
            "sterilely", "unrealize",
            "unpatched", "hypochondriacism",
            "critically", "cheesecutter",
    };
    private /*static final*/ long numBytesToWrite = (long) (300 * Math.pow(1024, 2));
    private /*static final*/ int minWordsInKey = 5;
    private /*static final*/ int wordsInKeyRange = 10 - minWordsInKey;
    private /*static final*/ int minWordsInValue = 10;
    private /*static final*/ int wordsInValueRange = 100 - minWordsInValue;
    private Random random = new Random();




   /* public void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        int itemCount = 0;
        while (numBytesToWrite > 0) {
            // Generate the key/value
            int key_word = minWordsInKey + (wordsInKeyRange != 0 ? random.nextInt(wordsInKeyRange) : 0);
            int value_word = minWordsInValue + (wordsInValueRange != 0 ? random.nextInt(wordsInValueRange) : 0);
            Text keyWords = generateSentence(key_word);
            Text valueWords = generateSentence(value_word);

            // Write the sentence
           // context.write(keyWords, valueWords);

            /*numBytesToWrite -= (valueWords.getLength());

            // Update counters, progress etc.
            context.getCounter(Counters.BYTES_WRITTEN).increment(keyWords.getLength() + valueWords.getLength());
            context.getCounter(Counters.RECORDS_WRITTEN).increment(1);
            if (++itemCount % 200 == 0) {
                context.setStatus(String.format("Wrote record %d . %d bytes left", itemCount, numBytesToWrite));
            }

        }

    }*/

    /**
     * Given an output filename, write a bunch of random records to it.
     *
     * @param key
     * @param value
     * @param context
     */
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        List<String> words = listOfWords(value);
        int itemCount = 0;
        while (numBytesToWrite > 0) {
            //Text valueWords = new Text(words.get(random.nextInt(words.size())));
            int key_word = minWordsInKey + (wordsInKeyRange != 0 ? random.nextInt(wordsInKeyRange) : 0);
            int value_word = minWordsInValue + (wordsInValueRange != 0 ? random.nextInt(wordsInValueRange) : 0);
            Text keyWords = generateSentence(key_word, words);
            Text valueWords = generateSentence(value_word, words);
            context.write(new Text(), valueWords);
            numBytesToWrite -= (valueWords.getLength());
            // Update counters, progress etc.
            context.getCounter(Counters.BYTES_WRITTEN).increment(valueWords.getLength());
            context.getCounter(Counters.RECORDS_WRITTEN).increment(1);
            if (++itemCount % 200 == 0) {
                context.setStatus(String.format("Wrote record %d . %d bytes left", itemCount, numBytesToWrite));
            }
        }
    }

    private List<String> listOfWords(Text value) {
        List<String> strings = new ArrayList<String>();
        //for(String line : value.toString()) {
        strings.add(value.toString());
        //}
        return strings;
    }

    /**
     * @param wordsNumbers
     * @return a new sentence
     */

    private Text generateSentence(int wordsNumbers, List<String> list) {
        StringBuffer sentence = new StringBuffer();
        String space = " ";

        for (int i = 0; i < wordsNumbers; i++) {
            sentence.append(list.get(random.nextInt(list.size())));
            sentence.append(space);
        }
        return new Text(sentence.toString());
    }

}









package LeetCodeTop100;

/**
 * @ClassName 单词接龙126
 * @Author zhangxinkun
 * @Date 2020/1/13  9:37 PM
 * @Version 1.0
 */

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 示例 1:
 *
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * 输出:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * 示例 2:
 *
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * 输出: []
 *
 * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
 *
 * 就是广度优先遍历
 */
public class 单词接龙126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> distance = new HashMap<>();
        Map<String,Integer> visit = new HashMap<>();
        int len = wordList.size();
        for(int i=0;i<len;i++){
            visit.put(wordList.get(i),0);
            distance.put(wordList.get(i),new ArrayList<>());
            for(int j=0;j<len;j++){
                if(i == j){
                    continue;
                }else{
                    if(distance(wordList.get(i),wordList.get(j))){
                        List<String> list = distance.get(wordList.get(i));
                        list.add(wordList.get(j));
                    }
                }
            }
        }
        distance.put(beginWord,new ArrayList<>());
        for(int i=0;i<len;i++){
            if(this.distance(beginWord,wordList.get(i))){
                distance.get(beginWord).add(wordList.get(i));
            }
        }
        class Path{
            int step;
            List<String> path = new ArrayList<>();
            String node;

            public Path() {
            }

            public int getStep() {
                return step;
            }

            public void setStep(int step) {
                this.step = step;
            }

            public List<String> getPath() {
                return path;
            }

            public void setPath(List<String> path) {
                this.path = path;
            }

            public String getNode() {
                return node;
            }

            public void setNode(String node) {
                this.node = node;
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Queue<Path> queue = new ArrayDeque<>();
        Path begin = new Path();
        begin.setNode(beginWord);
        begin.setStep(1);
        begin.getPath().add(beginWord);
        queue.add(begin);
        int Min = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Path now = queue.peek();
            queue.poll();
            Set<String> secondVisit = new HashSet<>();
            if(now.getStep() > Min){
                continue;
            }
            if(now.getNode().equals(endWord)){
                Min = Math.min(Min,now.getStep());
//                ans.add(now.getPath());
            }

            for(String temp:distance.get(now.getNode())){
                if(visit.get(temp).equals(0)){
                    visit.put(temp,1);
                    Path next = new Path();
                    next.setStep(now.getStep()+1);
                    next.setNode(temp);
                    next.setPath(new ArrayList<>(now.getPath()));
                    next.getPath().add(temp);
                    queue.offer(next);
                }
            }
        }
        if(Min == Integer.MAX_VALUE){
            return ans;
        }
        queue.clear();
        begin = new Path();
        begin.setNode(beginWord);
        begin.setStep(1);
        begin.getPath().add(beginWord);
        queue.add(begin);
        queue.add(begin);

        while(!queue.isEmpty()){
            Path now = queue.peek();
            queue.poll();
            Set<String> secondVisit = new HashSet<>();
            if(now.getStep() > Min){
                continue;
            }
            if(now.getNode().equals(endWord)){
                Min = Math.min(Min,now.getStep());
                ans.add(now.getPath());
            }

            for(String temp:distance.get(now.getNode())){
                if(true){
                    visit.put(temp,1);
                    Path next = new Path();
                    next.setStep(now.getStep()+1);
                    next.setNode(temp);
                    next.setPath(new ArrayList<>(now.getPath()));
                    next.getPath().add(temp);
                    queue.offer(next);
                }
            }
        }
        ans = ans.stream().distinct().collect(Collectors.toList());
        return ans;
    }

    public boolean distance(String a,String b){
        int len1 = a.length();
        int len2 = b.length();
        int i=0;
        int num = 0;
        while(i<len1){
            if(a.charAt(i) != b.charAt(i)){
                num++;
            }
            i++;
        }
        return num == 1;
    }

    public static void main(String[] args){
        单词接龙126 test = new 单词接龙126();
        String begin = "cet";
        String end = "ism";
        List<String> path = Arrays.asList("kid",
                "tag",
                "pup",
                "ail",
                "tun",
                "woo",
                "erg",
                "luz",
                "brr",
                "gay",
                "sip",
                "kay",
                "per",
                "val",
                "mes",
                "ohs",
                "now",
                "boa",
                "cet",
                "pal",
                "bar",
                "die",
                "war",
                "hay",
                "eco",
                "pub",
                "lob",
                "rue",
                "fry",
                "lit",
                "rex",
                "jan",
                "cot",
                "bid",
                "ali",
                "pay",
                "col",
                "gum",
                "ger",
                "row",
                "won",
                "dan",
                "rum",
                "fad",
                "tut",
                "sag",
                "yip",
                "sui",
                "ark",
                "has",
                "zip",
                "fez",
                "own",
                "ump",
                "dis",
                "ads",
                "max",
                "jaw",
                "out",
                "btu",
                "ana",
                "gap",
                "cry",
                "led",
                "abe",
                "box",
                "ore",
                "pig",
                "fie",
                "toy",
                "fat",
                "cal",
                "lie",
                "noh",
                "sew",
                "ono",
                "tam",
                "flu",
                "mgm",
                "ply",
                "awe",
                "pry",
                "tit",
                "tie",
                "yet",
                "too",
                "tax",
                "jim",
                "san",
                "pan",
                "map",
                "ski",
                "ova",
                "wed",
                "non",
                "wac",
                "nut",
                "why",
                "bye",
                "lye",
                "oct",
                "old",
                "fin",
                "feb",
                "chi",
                "sap",
                "owl",
                "log",
                "tod",
                "dot",
                "bow",
                "fob",
                "for",
                "joe",
                "ivy",
                "fan",
                "age",
                "fax",
                "hip",
                "jib",
                "mel",
                "hus",
                "sob",
                "ifs",
                "tab",
                "ara",
                "dab",
                "jag",
                "jar",
                "arm",
                "lot",
                "tom",
                "sax",
                "tex",
                "yum",
                "pei",
                "wen",
                "wry",
                "ire",
                "irk",
                "far",
                "mew",
                "wit",
                "doe",
                "gas",
                "rte",
                "ian",
                "pot",
                "ask",
                "wag",
                "hag",
                "amy",
                "nag",
                "ron",
                "soy",
                "gin",
                "don",
                "tug",
                "fay",
                "vic",
                "boo",
                "nam",
                "ave",
                "buy",
                "sop",
                "but",
                "orb",
                "fen",
                "paw",
                "his",
                "sub",
                "bob",
                "yea",
                "oft",
                "inn",
                "rod",
                "yam",
                "pew",
                "web",
                "hod",
                "hun",
                "gyp",
                "wei",
                "wis",
                "rob",
                "gad",
                "pie",
                "mon",
                "dog",
                "bib",
                "rub",
                "ere",
                "dig",
                "era",
                "cat",
                "fox",
                "bee",
                "mod",
                "day",
                "apr",
                "vie",
                "nev",
                "jam",
                "pam",
                "new",
                "aye",
                "ani",
                "and",
                "ibm",
                "yap",
                "can",
                "pyx",
                "tar",
                "kin",
                "fog",
                "hum",
                "pip",
                "cup",
                "dye",
                "lyx",
                "jog",
                "nun",
                "par",
                "wan",
                "fey",
                "bus",
                "oak",
                "bad",
                "ats",
                "set",
                "qom",
                "vat",
                "eat",
                "pus",
                "rev",
                "axe",
                "ion",
                "six",
                "ila",
                "lao",
                "mom",
                "mas",
                "pro",
                "few",
                "opt",
                "poe",
                "art",
                "ash",
                "oar",
                "cap",
                "lop",
                "may",
                "shy",
                "rid",
                "bat",
                "sum",
                "rim",
                "fee",
                "bmw",
                "sky",
                "maj",
                "hue",
                "thy",
                "ava",
                "rap",
                "den",
                "fla",
                "auk",
                "cox",
                "ibo",
                "hey",
                "saw",
                "vim",
                "sec",
                "ltd",
                "you",
                "its",
                "tat",
                "dew",
                "eva",
                "tog",
                "ram",
                "let",
                "see",
                "zit",
                "maw",
                "nix",
                "ate",
                "gig",
                "rep",
                "owe",
                "ind",
                "hog",
                "eve",
                "sam",
                "zoo",
                "any",
                "dow",
                "cod",
                "bed",
                "vet",
                "ham",
                "sis",
                "hex",
                "via",
                "fir",
                "nod",
                "mao",
                "aug",
                "mum",
                "hoe",
                "bah",
                "hal",
                "keg",
                "hew",
                "zed",
                "tow",
                "gog",
                "ass",
                "dem",
                "who",
                "bet",
                "gos",
                "son",
                "ear",
                "spy",
                "kit",
                "boy",
                "due",
                "sen",
                "oaf",
                "mix",
                "hep",
                "fur",
                "ada",
                "bin",
                "nil",
                "mia",
                "ewe",
                "hit",
                "fix",
                "sad",
                "rib",
                "eye",
                "hop",
                "haw",
                "wax",
                "mid",
                "tad",
                "ken",
                "wad",
                "rye",
                "pap",
                "bog",
                "gut",
                "ito",
                "woe",
                "our",
                "ado",
                "sin",
                "mad",
                "ray",
                "hon",
                "roy",
                "dip",
                "hen",
                "iva",
                "lug",
                "asp",
                "hui",
                "yak",
                "bay",
                "poi",
                "yep",
                "bun",
                "try",
                "lad",
                "elm",
                "nat",
                "wyo",
                "gym",
                "dug",
                "toe",
                "dee",
                "wig",
                "sly",
                "rip",
                "geo",
                "cog",
                "pas",
                "zen",
                "odd",
                "nan",
                "lay",
                "pod",
                "fit",
                "hem",
                "joy",
                "bum",
                "rio",
                "yon",
                "dec",
                "leg",
                "put",
                "sue",
                "dim",
                "pet",
                "yaw",
                "nub",
                "bit",
                "bur",
                "sid",
                "sun",
                "oil",
                "red",
                "doc",
                "moe",
                "caw",
                "eel",
                "dix",
                "cub",
                "end",
                "gem",
                "off",
                "yew",
                "hug",
                "pop",
                "tub",
                "sgt",
                "lid",
                "pun",
                "ton",
                "sol",
                "din",
                "yup",
                "jab",
                "pea",
                "bug",
                "gag",
                "mil",
                "jig",
                "hub",
                "low",
                "did",
                "tin",
                "get",
                "gte",
                "sox",
                "lei",
                "mig",
                "fig",
                "lon",
                "use",
                "ban",
                "flo",
                "nov",
                "jut",
                "bag",
                "mir",
                "sty",
                "lap",
                "two",
                "ins",
                "con",
                "ant",
                "net",
                "tux",
                "ode",
                "stu",
                "mug",
                "cad",
                "nap",
                "gun",
                "fop",
                "tot",
                "sow",
                "sal",
                "sic",
                "ted",
                "wot",
                "del",
                "imp",
                "cob",
                "way",
                "ann",
                "tan",
                "mci",
                "job",
                "wet",
                "ism",
                "err",
                "him",
                "all",
                "pad",
                "hah",
                "hie",
                "aim",
                "ike",
                "jed",
                "ego",
                "mac",
                "baa",
                "min",
                "com",
                "ill",
                "was",
                "cab",
                "ago",
                "ina",
                "big",
                "ilk",
                "gal",
                "tap",
                "duh",
                "ola",
                "ran",
                "lab",
                "top",
                "gob",
                "hot",
                "ora",
                "tia",
                "kip",
                "han",
                "met",
                "hut",
                "she",
                "sac",
                "fed",
                "goo",
                "tee",
                "ell",
                "not",
                "act",
                "gil",
                "rut",
                "ala",
                "ape",
                "rig",
                "cid",
                "god",
                "duo",
                "lin",
                "aid",
                "gel",
                "awl",
                "lag",
                "elf",
                "liz",
                "ref",
                "aha",
                "fib",
                "oho",
                "tho",
                "her",
                "nor",
                "ace",
                "adz",
                "fun",
                "ned",
                "coo",
                "win",
                "tao",
                "coy",
                "van",
                "man",
                "pit",
                "guy",
                "foe",
                "hid",
                "mai",
                "sup",
                "jay",
                "hob",
                "mow",
                "jot",
                "are",
                "pol",
                "arc",
                "lax",
                "aft",
                "alb",
                "len",
                "air",
                "pug",
                "pox",
                "vow",
                "got",
                "meg",
                "zoe",
                "amp",
                "ale",
                "bud",
                "gee",
                "pin",
                "dun",
                "pat",
                "ten",
                "mob");
        test.findLadders(begin,end,path);
    }
}

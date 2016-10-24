package datastructure.downto0;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/19/2016.
 */
public class TreeSetq2 {
    public static int bfs(int m) {

        Map<Integer, HashSet<Integer>> known = new HashMap<>();


        Integer s0[] = {0};
        Integer s1[] = {1};
        Integer s2[] = {2};
        Integer s3[] = {3, 4};
        Integer s4[] = {5, 6, 8, 9, 12, 16};
        Integer s5[] = {7, 10, 13, 15, 17, 18, 20, 24, 25, 27, 30, 32, 36, 40, 45, 48, 54, 56, 60, 63, 64, 72, 80, 81, 84, 96, 108, 112, 120, 128, 132, 144, 160, 176, 192, 208, 224, 240, 256};
        Integer s6[] = {11, 14, 19, 21, 26, 28, 31, 33, 34, 35, 37, 39, 41, 42, 46, 49, 50, 51, 52, 55, 57, 61, 65, 68, 70, 73, 75, 78, 82, 85, 90, 91, 97, 100, 102, 104, 105, 109, 113, 117, 119, 121, 125, 126, 129, 130, 133, 135, 136, 140, 143, 145, 150, 153, 156, 161, 162, 165, 168, 169, 170, 175, 177, 180, 187, 189, 193, 195, 198, 200, 204, 209, 210, 216, 220, 221, 225, 234, 238, 241, 243, 250, 252, 255, 257, 260, 264, 270, 272, 275, 280, 288, 289, 297, 300, 306, 312, 315, 320, 324, 325, 330, 336, 340, 350, 351, 352, 360, 375, 378, 380, 384, 390, 392, 396, 400, 405, 408, 416, 420, 425, 432, 440, 441, 448, 450, 456, 459, 468, 475, 480, 486, 495, 500, 504, 510, 512, 513, 520, 525, 528, 540, 544, 550, 552, 560, 567, 570, 575, 576, 585, 588, 594, 600, 608, 612, 616, 621, 624, 625, 630, 640, 648, 660, 672, 675, 680, 684, 690, 693, 702, 704, 720, 728, 729, 736, 750, 756, 760, 765, 768, 780, 784, 792, 800, 810, 816, 819, 828, 832, 840, 855, 864, 870, 880, 882, 891, 896, 900, 912, 918, 920, 924, 928, 936, 945, 952, 960, 972, 990, 992, 1000, 1008, 1020, 1024, 1026, 1035, 1040, 1044, 1053, 1056, 1064, 1071, 1080, 1088, 1092, 1104, 1116, 1120, 1125, 1134, 1140, 1152, 1160, 1170, 1176, 1188, 1197, 1200, 1215, 1216, 1224, 1232, 1240, 1242, 1248, 1260, 1280, 1288, 1296, 1305, 1320, 1323, 1344, 1350, 1360, 1368, 1377, 1380, 1386, 1392, 1395, 1400, 1404, 1408, 1428, 1440, 1449, 1452, 1456, 1458, 1472, 1480, 1485, 1488, 1500, 1512, 1520, 1530, 1536, 1539, 1560, 1566, 1568, 1575, 1584, 1596, 1600, 1620, 1624, 1632, 1638, 1656, 1664, 1665, 1674, 1680, 1701, 1710, 1716, 1728, 1736, 1740, 1755, 1760, 1764, 1776, 1782, 1792, 1800, 1824, 1827, 1836, 1840, 1845, 1848, 1856, 1860, 1863, 1872, 1890, 1904, 1920, 1932, 1935, 1936, 1944, 1953, 1960, 1968, 1980, 1984, 1998, 2000, 2016, 2025, 2040, 2048, 2052, 2064, 2072, 2079, 2080, 2088, 2100, 2106, 2112, 2128, 2142, 2160, 2176, 2184, 2187, 2205, 2208, 2214, 2220, 2232, 2240, 2244, 2256, 2268, 2280, 2288, 2296, 2304, 2320, 2322, 2331, 2340, 2349, 2352, 2368, 2376, 2394, 2400, 2408, 2430, 2432, 2436, 2448, 2457, 2460, 2464, 2480, 2484, 2496, 2508, 2511, 2520, 2538, 2560, 2576, 2580, 2583, 2592, 2604, 2624, 2632, 2640, 2646, 2664, 2673, 2688, 2700, 2704, 2709, 2720, 2736, 2744, 2752, 2754, 2760, 2772, 2784, 2800, 2808, 2816, 2820, 2835, 2856, 2862, 2880, 2898, 2904, 2912, 2916, 2940, 2944, 2952, 2960, 2961, 2968, 2976, 2992, 2997, 3000, 3008, 3024, 3036, 3040, 3060, 3072, 3078, 3080, 3087, 3096, 3108, 3120, 3132, 3136, 3150, 3159, 3168, 3180, 3192, 3200, 3213, 3240, 3248, 3264, 3276, 3280, 3300, 3312, 3321, 3328, 3339, 3344, 3348, 3360, 3384, 3392, 3402, 3420, 3432, 3440, 3444, 3456, 3465, 3472, 3480, 3483, 3520, 3528, 3536, 3540, 3552, 3564, 3584, 3591, 3600, 3612, 3645, 3648, 3654, 3672, 3680, 3696, 3712, 3717, 3720, 3726, 3744, 3760, 3776, 3780, 3807, 3808, 3816, 3828, 3840, 3843, 3864, 3872, 3888, 3904, 3906, 3920, 3936, 3948, 3952, 3960, 3968, 3969, 3996, 4000, 4032, 4048, 4050, 4080, 4092, 4096, 4104, 4116, 4128, 4131, 4144, 4160, 4176, 4200, 4212, 4224, 4240, 4248, 4256, 4284, 4293, 4320, 4352, 4356, 4368, 4374, 4392, 4400, 4416, 4428, 4440, 4452, 4455, 4464, 4480, 4488, 4512, 4536, 4560, 4576, 4592, 4608, 4617, 4620, 4640, 4644, 4680, 4698, 4704, 4720, 4736, 4752, 4779, 4784, 4788, 4800, 4816, 4824, 4860, 4864, 4872, 4880, 4884, 4896, 4920, 4928, 4941, 4956, 4960, 4968, 4992, 5016, 5022, 5040, 5076, 5088, 5103, 5104, 5112, 5120, 5124, 5148, 5152, 5160, 5184, 5200, 5208, 5248, 5264, 5265, 5280, 5292, 5328, 5346, 5360, 5376, 5400, 5408, 5412, 5427, 5440, 5456, 5460, 5472, 5488, 5504, 5508, 5520, 5544, 5568, 5589, 5600, 5616, 5628, 5632, 5640, 5664, 5670, 5676, 5680, 5712, 5724, 5751, 5760, 5796, 5808, 5824, 5832, 5840, 5856, 5880, 5888, 5904, 5913, 5920, 5936, 5940, 5952, 5964, 5984, 5994, 6000, 6016, 6032, 6048, 6072, 6075, 6080, 6120, 6132, 6144, 6156, 6160, 6192, 6204, 6216, 6237, 6240, 6264, 6272, 6300, 6318, 6320, 6336, 6360, 6372, 6384, 6399, 6400, 6432, 6448, 6468, 6480, 6496, 6512, 6528, 6552, 6560, 6561, 6588, 6600, 6608, 6624, 6636, 6656, 6688, 6696, 6720, 6732, 6768, 6784, 6804, 6816, 6832, 6840, 6864, 6880, 6888, 6912, 6944, 6960, 6972, 6996, 7008, 7020, 7040, 7056, 7072, 7080, 7104, 7128, 7168, 7200, 7216, 7236, 7260, 7280, 7296, 7320, 7344, 7360, 7392, 7424, 7440, 7452, 7488, 7504, 7520, 7524, 7552, 7560, 7568, 7584, 7616, 7632, 7656, 7668, 7680, 7696, 7728, 7744, 7776, 7788, 7800, 7808, 7840, 7872, 7884, 7904, 7920, 7936, 7952, 7968, 7992, 8000, 8040, 8052, 8064, 8096, 8100, 8112, 8160, 8176, 8184, 8192, 8208, 8256, 8272, 8280, 8288, 8316, 8320, 8352, 8400, 8424, 8448, 8480, 8496, 8512, 8520, 8528, 8532, 8544, 8576, 8580, 8624, 8640, 8704, 8712, 8736, 8748, 8760, 8784, 8800, 8832, 8844, 8848, 8856, 8880, 8928, 8944, 8960, 8964, 8976, 9000, 9024, 9072, 9088, 9108, 9120, 9152, 9180, 9184, 9216, 9240, 9280, 9288, 9296, 9328, 9344, 9360, 9372, 9396, 9408, 9440, 9472, 9480, 9504, 9520, 9568, 9600, 9612, 9632, 9636, 9648, 9680, 9720, 9728, 9744, 9760, 9768, 9776, 9792, 9828, 9840, 9856, 9900, 9920, 9936, 9960, 9968, 9984, 10032, 10044, 10080, 10112, 10152, 10164, 10176, 10192, 10200, 10208, 10224, 10240, 10260, 10296, 10304, 10320, 10368, 10384, 10400, 10416, 10428, 10440, 10476, 10496, 10512, 10528, 10560, 10584, 10608, 10624, 10640, 10656, 10680, 10692, 10720, 10736, 10752, 10800, 10816, 10824, 10864, 10880, 10908, 10912, 10920, 10944, 10956, 10976, 11008, 11016, 11024, 11040, 11088, 11124, 11136, 11160, 11200, 11220, 11232, 11264, 11280, 11312, 11328, 11340, 11352, 11360, 11376, 11392, 11400, 11424, 11440, 11448, 11484, 11520, 11536, 11556, 11616, 11640, 11648, 11664, 11680, 11712, 11748, 11760, 11776, 11792, 11808, 11840, 11856, 11872, 11880, 11904, 11952, 11968, 11984, 12000, 12012, 12032, 12064, 12096, 12120, 12144, 12160, 12208, 12240, 12272, 12276, 12288, 12320, 12360, 12384, 12408, 12416, 12432, 12480, 12496, 12528, 12540, 12544, 12600, 12640, 12672, 12688, 12720, 12768, 12800, 12804, 12816, 12840, 12848, 12864, 12896, 12928, 12936, 12960, 12992, 13024, 13056, 13068, 13080, 13104, 13120, 13184, 13200, 13216, 13248, 13280, 13312, 13320, 13332, 13376, 13392, 13440, 13464, 13520, 13536, 13552, 13560, 13568, 13596, 13600, 13632, 13664, 13680, 13696, 13728, 13760, 13800, 13824, 13860, 13888, 13904, 13920, 13936, 13952, 13968, 13992, 14016, 14040, 14080, 14112, 14124, 14144, 14160, 14208, 14240, 14256, 14280, 14336, 14352, 14388, 14400, 14432, 14464, 14520, 14544, 14560, 14592, 14608, 14640, 14652, 14688, 14720, 14768, 14784, 14832, 14848, 14880, 14916, 14960, 14976, 15008, 15040, 15048, 15104, 15120, 15136, 15168, 15180, 15184, 15200, 15232, 15264, 15312, 15360, 15392, 15408, 15444, 15456, 15488, 15520, 15552, 15576, 15600, 15616, 15664, 15680, 15696, 15708, 15744, 15808, 15840, 15872, 15904, 15936, 15972, 15984, 16000, 16016, 16080, 16104, 16128, 16160, 16192, 16224, 16236, 16256, 16272, 16320, 16352, 16368, 16384, 16416, 16432, 16480, 16500, 16512, 16544, 16560, 16576, 16632, 16640, 16704, 16720, 16764, 16800, 16848, 16896, 16960, 16992, 17024, 17028, 17040, 17056, 17072, 17088, 17120, 17136, 17152, 17160, 17248, 17264, 17280, 17292, 17408, 17424, 17440, 17472, 17520, 17568, 17600, 17664, 17680, 17696, 17712, 17760, 17776, 17856, 17888, 17920, 17952, 18000, 18048, 18080, 18096, 18128, 18144, 18176, 18240, 18288, 18304, 18368, 18400, 18432, 18480, 18512, 18560, 18576, 18592, 18624, 18656, 18688, 18720, 18816, 18832, 18864, 18880, 18928, 18944, 18960, 19008, 19040, 19136, 19152, 19184, 19200, 19264, 19296, 19344, 19360, 19392, 19440, 19456, 19488, 19520, 19536, 19552, 19584, 19680, 19712, 19728, 19760, 19776, 19840, 19872, 19888, 19920, 19936, 19968, 20000, 20016, 20064, 20160, 20176, 20224, 20240, 20304, 20320, 20352, 20384, 20400, 20416, 20448, 20480, 20544, 20592, 20608, 20640, 20736, 20768, 20800, 20832, 20880, 20928, 20944, 20960, 20992, 21008, 21056, 21120, 21216, 21248, 21280, 21296, 21312, 21360, 21424, 21440, 21472, 21504, 21600, 21632, 21648, 21696, 21728, 21760, 21824, 21840, 21888, 21920, 21952, 22000, 22016, 22048, 22080, 22176, 22240, 22256, 22272, 22320, 22352, 22400, 22464, 22528, 22560, 22624, 22656, 22672, 22704, 22720, 22784, 22800, 22848, 22880, 23040, 23056, 23072, 23088, 23200, 23232, 23280, 23296, 23360, 23408, 23424, 23504, 23520, 23552, 23584, 23616, 23680, 23712, 23744, 23760, 23808, 23840, 23920, 23936, 23968, 24000, 24064, 24112, 24128, 24160, 24192, 24240, 24288, 24320, 24336, 24384, 24416, 24464, 24480, 24544, 24576, 24640, 24720, 24752, 24768, 24800, 24816, 24832, 24864, 24960, 24992, 25088, 25120, 25152, 25168, 25200, 25280, 25312, 25344, 25376, 25440, 25520, 25536, 25584, 25600, 25680, 25696, 25728, 25760, 25792, 25856, 25872, 25920, 25984, 26000, 26048, 26112, 26160, 26208, 26224, 26304, 26368, 26400, 26416, 26432, 26496, 26576, 26624, 26640, 26656, 26688, 26752, 26832, 26880, 26928, 27040, 27072, 27104, 27120, 27136, 27248, 27264, 27280, 27328, 27360, 27392, 27456, 27552, 27600, 27632, 27648, 27664, 27776, 27808, 27840, 27872, 27904, 27984, 28000, 28032, 28080, 28160, 28224, 28288, 28320, 28336, 28416, 28448, 28496, 28512, 28560, 28608, 28672, 28688, 28704, 28800, 28864, 28896, 28912, 28928, 28992, 29040, 29120, 29184, 29216, 29280, 29328, 29344, 29376, 29392, 29440, 29520, 29536, 29568, 29696, 29744, 29760, 29792, 29920, 29952, 30000, 30016, 30096, 30144, 30160, 30208, 30240, 30272, 30336, 30368, 30448, 30464, 30480, 30528, 30576, 30624, 30688, 30720, 30784, 30800, 30912, 30960, 30976, 30992, 31104, 31136, 31200, 31232, 31296, 31360, 31408, 31440, 31488, 31584, 31616, 31680, 31744, 31808, 31824, 31872, 31920, 32000, 32032, 32064, 32160, 32240, 32256, 32400, 32448, 32480, 32512, 32640, 32656, 32704, 32768, 32832, 32864, 32880, 32928, 33024, 33072, 33120, 33152, 33216, 33280, 33360, 33376, 33408, 33488, 33536, 33600, 33696, 33792, 33824, 33840, 33904, 33984, 34048, 34080, 34112, 34176, 34272, 34304, 34320, 34368, 34496, 34528, 34560, 34720, 34736, 34752, 34800, 34816, 34944, 35040, 35072, 35136, 35152, 35168, 35280, 35328, 35360, 35392, 35520, 35568, 35584, 35616, 35712, 35760, 35776, 35840, 35904, 35984, 36000, 36064, 36096, 36192, 36240, 36288, 36352, 36400, 36480, 36512, 36608, 36672, 36720, 36736, 36816, 36864, 36960, 37024, 37120, 37184, 37200, 37232, 37376, 37408, 37440, 37632, 37648, 37680, 37856, 37888, 37920, 38064, 38080, 38144, 38160, 38272, 38304, 38400, 38480, 38528, 38640, 38656, 38688, 38752, 38880, 38896, 38912, 38976, 39104, 39120, 39168, 39200, 39312, 39360, 39424, 39520, 39600, 39648, 39680, 39728, 39840, 39872, 39936, 40080, 40096, 40144, 40192, 40320, 40352, 40448, 40544, 40560, 40704, 40768, 40800, 40960, 40976, 40992, 41040, 41184, 41216, 41280, 41392, 41440, 41472, 41520, 41600, 41664, 41728, 41760, 41808, 41888, 41984, 42000, 42016, 42112, 42224, 42240, 42336, 42432, 42480, 42496, 42560, 42640, 42720, 42752, 42784, 42848, 42960, 43008, 43056, 43200, 43232, 43264, 43440, 43456, 43520, 43680, 43776, 43904, 43920, 44032, 44128, 44160, 44288, 44352, 44400, 44544, 44576, 44640, 44800, 44880, 45024, 45056, 45120, 45248, 45312, 45360, 45472, 45568, 45600, 45696, 45824, 45840, 45920, 46080, 46144, 46320, 46336, 46368, 46560, 46592, 46800, 46816, 46848, 47040, 47104, 47264, 47280, 47360, 47488, 47520, 47616, 47712, 47760, 47872, 47936, 48000, 48128, 48160, 48240, 48384, 48480, 48608, 48640, 48720, 48832, 48896, 48960, 49056, 49152, 49200, 49280, 49408, 49440, 49504, 49664, 49680, 49728, 49920, 49952, 50160, 50176, 50400, 50432, 50640, 50688, 50880, 50944, 51120, 51200, 51360, 51456, 51600, 51712, 51840, 51968, 52080, 52224, 52320, 52480, 52560, 52736, 52800, 52992, 53040, 53248, 53280, 53504, 53520, 53760, 54000, 54016, 54240, 54272, 54480, 54528, 54720, 54784, 54960, 55040, 55200, 55296, 55440, 55552, 55680, 55808, 55920, 56064, 56160, 56320, 56400, 56576, 56640, 56832, 56880, 57088, 57120, 57344, 57360, 57600, 57856, 58112, 58368, 58624, 58880, 59136, 59392, 59648, 59904, 60160, 60416, 60672, 60928, 61184, 61440, 61696, 61952, 62208, 62464, 62720, 62976, 63232, 63488, 63744, 64000, 64256, 64512, 64768, 65024, 65280, 65536};
        HashSet<Integer> set0 = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> set3 = new HashSet<>();
        HashSet<Integer> set4 = new HashSet<>();
        HashSet<Integer> set5 = new HashSet<>();
        HashSet<Integer> set6 = new HashSet<>();
        set0.addAll(new ArrayList<>(Arrays.asList(s0)));
        set1.addAll(new ArrayList<>(Arrays.asList(s1)));
        set2.addAll(new ArrayList<>(Arrays.asList(s2)));
        set3.addAll(new ArrayList<>(Arrays.asList(s3)));
        set4.addAll(new ArrayList<>(Arrays.asList(s4)));
        set5.addAll(new ArrayList<>(Arrays.asList(s5)));
        set6.addAll(new ArrayList<>(Arrays.asList(s6)));

        known.put(0, set0);
        known.put(1, set1);
        known.put(2, set2);
        known.put(3, set3);
        known.put(4, set4);
        known.put(5, set5);
        known.put(6, set6);
        if (known.get(0).contains(m))
            return 0;
        if (known.get(1).contains(m))
            return 1;
        if (known.get(2).contains(m))
            return 2;
        if (known.get(3).contains(m))
            return 3;
        if (known.get(4).contains(m))
            return 4;
        if (known.get(5).contains(m))
            return 5;
        if (known.get(6).contains(m))
            return 6;

        int step = 0;
        TreeSet<Integer> prev = new TreeSet<>();
        Set<Integer> visited = new HashSet<>();


        prev.add(m);
        TreeSet<Integer> curr;
        while (true) {
            step++;
            curr = new TreeSet<>();
            for (int i : prev) {
                for (int k = i-1; k>= Math.sqrt(i); k--) {

                    if (i%k == 0 && !visited.contains(k)) {
                        //check know set.
                        if (known.get(2).contains(k))
                            return step + 2;
                        if (known.get(3).contains(k))
                            return step + 3;
                        if (known.get(4).contains(k))
                            return step + 4;
                        if (known.get(5).contains(k))
                            return step + 5;
                        if (known.get(6).contains(k))
                            return step + 6;
                        curr.add(k);
                        visited.add(k);
                    }
                }
                if (!visited.contains(i-1)) {
                    if (known.get(2).contains(i-1))
                        return step + 2;
                    if (known.get(3).contains(i-1))
                        return step + 3;
                    if (known.get(4).contains(i-1))
                        return step + 4;
                    if (known.get(5).contains(i-1))
                        return step + 5;
                    if (known.get(6).contains(i-1))
                        return step + 6;
                    curr.add(i - 1);
                    visited.add(i-1);
                }
            }
         //   System.out.println(curr);
            prev = curr;
        }
    }


    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("./testcase/downzero1.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int n = scanner.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n; i++) {
            a[i] = scanner.nextInt();
        }
        long tb = System.currentTimeMillis();
        for (int i = 0; i<n; i++)
            TreeSetq.bfs(a[i]);
        long te = System.currentTimeMillis();
        System.out.println(te-tb);

    }
}

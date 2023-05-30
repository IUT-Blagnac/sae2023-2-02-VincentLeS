package exercice;
import java.util.List;
import java.util.ArrayList;

public class EfficaciteMeilleur {
public static List<String> solution(String s, List<Character> o) {
List<String> r = new ArrayList<String>();

ArrayList<String> lm = (new ArrayList<String>());
String ad = "";
for (int i = 0; i <= s.length(); i++) {
if (i == s.length()) {
lm.add(ad);
} else if (s.charAt(i) == ' ') {
lm.add(ad);
ad = "";
} else {
ad += s.charAt(i);
}
}

for (int i = 0; i < o.size(); i++) {
for (int j = 0; j < lm.size(); j++) {
if (o.get(i) == lm.get(j).charAt(0)) {
r.add(lm.get(j));
lm.remove(j);
}
}
}
for (int i = 0; i < lm.size(); i=i+1) {
if (lm.get(i) != null) {
r.add(lm.get(i));
}
}
return r;
}
}

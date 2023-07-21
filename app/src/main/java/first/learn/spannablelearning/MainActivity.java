package first.learn.spannablelearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtForeground, txtBackground, txtSize, txtStyle, txtAppearance, txtConcat ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtForeground = (TextView) findViewById(R.id.txtForeground);
        txtBackground = (TextView)findViewById(R.id.txtBackground);
        txtSize = (TextView)findViewById(R.id.txtSize);
        txtStyle = (TextView)findViewById(R.id.txtStyle);
        txtAppearance = (TextView)findViewById(R.id.txtAppearance);
        txtConcat = (TextView)findViewById(R.id.txtConcat);

        String one = "This is ForeGround Span";
        Spannable spOne = new SpannableString(one);
        spOne.setSpan(new ForegroundColorSpan(Color.RED),8,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );

        txtForeground.setText(spOne);


        String two = "This is Background Color Span And Insert";

        SpannableStringBuilder spTwo = new SpannableStringBuilder(two);

        spTwo.setSpan(new BackgroundColorSpan(Color.BLUE), 8, 24, Spanned.SPAN_EXCLUSIVE_INCLUSIVE );
        spTwo.setSpan(new ForegroundColorSpan(Color.WHITE), 8, 24, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spTwo.insert(25, "Blue");

        txtBackground.setText(spTwo);


        String three = "This is Size Span";
        Spannable spThree = new SpannableString(three);

        spThree.setSpan(new RelativeSizeSpan(1.5f), 8, 12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spThree.setSpan(new ForegroundColorSpan(Color.RED),8,12, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );


        txtSize.setText(spThree);



        String four = "This is Style Span";
        Spannable spFour = new SpannableString(four);
        spFour.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 8, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtStyle.setText(spFour);


        String five = "This is Text Appearance";
        Spannable spFive =  new SpannableString(five);
        ColorStateList blueColor = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.BLUE});
       TextAppearanceSpan span = new TextAppearanceSpan("serif", Typeface.BOLD, 70, blueColor, null );

        spFive.setSpan(span, 8, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtAppearance.setText(spFive);



        String a = "This is String a";
        String b = "This is String b";
        String c = "This is String c";

        String d = a + b+ c;

        String e = spOne.toString() + spTwo + spThree + spFour + spFive ;

        CharSequence charSequence = TextUtils.concat(spOne, "\n\n", "This is Simple String", "\n\n", spTwo, "\n\n", spThree, "\n\n", spFour, "\n\n", spFive);

        txtConcat.setText(charSequence);




    }


    @Override
    protected void onPostResume() {
        super.onPostResume();
    }
}
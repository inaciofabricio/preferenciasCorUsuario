package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private Button botaoSalvar;
    private RadioGroup radioGroup;
    private RadioButton radioButtonSelecionado;
    private static final String ARQUIVO_PREFERENICA = "arquivo";
    private RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrupoId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);


        botaoSalvar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                int idRadioButtonEscolhido = radioGroup.getCheckedRadioButtonId();

                if(idRadioButtonEscolhido > 0){
                    radioButtonSelecionado = (RadioButton) findViewById(idRadioButtonEscolhido);

                    String corEscolhida = radioButtonSelecionado.getText().toString();

                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENICA,0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("corEscolhida",corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENICA,0);
        if(sharedPreferences.contains("corEscolhida")){
            String corRecuperada = sharedPreferences.getString("corEscolhida","Laranja");
            setBackground(corRecuperada);
        }
    }

    private void setBackground(String cor){

        if(cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#495b7c"));
        }else if(cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ffce26"));
        }else if(cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#009670"));
        }
    }
}

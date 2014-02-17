package search;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import com.huibinfeng0810.Sample.R;

/**
 * Created by huibin on 2/12/14.
 */
public class OtherActivity extends Activity {

//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.listar_activity_actions, menu);
//
//        // Associate searchable configuration with the SearchView
//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));
//
//        return true;
//    }
//
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_new:
//                startActivity(new Intent(this, Inserir.class));
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.listar);
//    }
//
//    public void onResume(){
//        super.onResume();
//
//        SQLiteDatabase db = openOrCreateDatabase("objetos.db", Context.MODE_PRIVATE, null);
//
//        // Tabela de objetos
//        StringBuilder sqlClientes = new StringBuilder();
//        sqlClientes.append("CREATE TABLE IF NOT EXISTS objetos (");
//        sqlClientes.append("_id INTEGER PRIMARY KEY, ");
//        sqlClientes.append("nomeobj VARCHAR(30)); ");
//        db.execSQL(sqlClientes.toString());
//
//        Cursor cursor = db.rawQuery("SELECT * FROM objetos", null);
//
//        String[] from = {"nomeobj"};
//        int[] to = {R.id.NomeObj};
//
//        android.widget.SimpleCursorAdapter ad = new android.widget.SimpleCursorAdapter(getBaseContext(),
//                R.layout.listar_model, cursor, from, to);
//
//        ListView ltwDados = (ListView)findViewById(R.id.ltwDados);
//
//        ltwDados.setAdapter(ad);
//
//
//        ltwDados.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            public void onItemClick(AdapterView adapter, View view,
//                                    int position, long id) {
//
//                SQLiteCursor c = (SQLiteCursor) adapter.getAdapter().getItem(position);
//
//                Intent it = new Intent(getBaseContext(), Editar.class);
//                it.putExtra("id", c.getInt(0));
//                startActivity(it);
//            }
//        });
//
//        db.close();
//    }
}

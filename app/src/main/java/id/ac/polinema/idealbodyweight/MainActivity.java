package id.ac.polinema.idealbodyweight;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import id.ac.polinema.idealbodyweight.Fragment.AboutFragment;
import id.ac.polinema.idealbodyweight.Fragment.BrocaIndexFragment;
import id.ac.polinema.idealbodyweight.Fragment.MenuFragment;
import id.ac.polinema.idealbodyweight.Fragment.ResultFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener , BrocaIndexFragment.OnFragmentInteractionListener , ResultFragment.OnFragmentInteractionListener {

	private AboutFragment aboutFragment;
	private MenuFragment menuFragment;
	private BrocaIndexFragment brocaIndexFragment;
	private ResultFragment resultFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		aboutFragment = aboutFragment.newInstance("Harya Dwi Tama");
		menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, menuFragment)
				.commit();
		brocaIndexFragment = new BrocaIndexFragment();
		resultFragment = new ResultFragment();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		return  true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// TODO: Tambahkan penanganan menu di sini
		if (item.getItemId()== R.id.menu_about){
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,aboutFragment).addToBackStack(null).commit();
		}

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onBrocaIndexButtonClicked() {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}

	@Override
	public void onBodyMassIndexButtonClicked() {

	}

	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {

	}

	@Override
	public void onCalculateBrocaIndexClicked(float index) {
		resultFragment.setInformation(String.format("Your ideal weight is %.2f kg", index));
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, resultFragment)
				.commit();
	}

	@Override
	public void onTryAgainButtonClicked(String tag) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.fragment_container, brocaIndexFragment)
				.commit();
	}
}

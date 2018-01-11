package masterung.androidthai.in.th.getpostserialarduino.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import masterung.androidthai.in.th.getpostserialarduino.MainActivity;
import masterung.androidthai.in.th.getpostserialarduino.R;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by masterung on 11/1/2018 AD.
 */

public class MainFragment extends Fragment implements ZXingScannerView.ResultHandler{

    //    Explicit
    private ZXingScannerView zXingScannerView;
    private String resultCodeString;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Button Controller
        buttonController();

    }   // Main Method

    private void buttonController() {

        Button button = getView().findViewById(R.id.btnReceive);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanQRcode();
            }
        });

    }

    private void openScanQRcode() {

        Toast.makeText(getActivity(), getString(R.string.receive_ok),
                Toast.LENGTH_SHORT).show();

        zXingScannerView = new ZXingScannerView(getActivity());
        getActivity().setContentView(zXingScannerView);
        zXingScannerView.setResultHandler((ZXingScannerView.ResultHandler) getActivity());
        zXingScannerView.startCamera();




    }   // openScanQRcode

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

    @Override
    public void handleResult(Result result) {

        resultCodeString = result.getText().toString();
        Log.d("11JanV1", "resultCode ==> " + resultCodeString);



    }


}   // Main Class

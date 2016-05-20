package tv.piratemedia.lightcontroler;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.Wearable;
import java.util.List;

public class LightsOn extends FragmentActivity {
    public GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        mGoogleApiClient = new GoogleApiClient.Builder(this).addApi(Wearable.API).build();
        mGoogleApiClient.connect();

        if (mGoogleApiClient != null) {
            final PendingResult<NodeApi.GetConnectedNodesResult> nodes = Wearable.NodeApi.getConnectedNodes(mGoogleApiClient);
            nodes.setResultCallback(new ResultCallback<NodeApi.GetConnectedNodesResult>() {
                @Override
                public void onResult(NodeApi.GetConnectedNodesResult result) {
                    final List<Node> nodes = result.getNodes();
                    if (nodes != null) {
                        for (int i = 0; i < nodes.size(); i++) {
                            final Node node = nodes.get(i);
                            Wearable.MessageApi.sendMessage(mGoogleApiClient, node.getId(), "/0/on", null);
                        }
                    }
                }
            });
        }

        super.onCreate(savedInstanceState);
    }
}


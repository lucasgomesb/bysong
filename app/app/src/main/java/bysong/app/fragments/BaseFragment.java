package bysong.app.fragments;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;


/**
 * Created by Tiago on 11/08/2016.
 * Classe Pai para todas as fragments do app.
 * Contém métodos utilitários para a Fragment
 */
public class BaseFragment extends Fragment {

    // Interface de interação com AsyncTask
    public interface OnClickTask {

        void execute();
        void updateView();

    }

    protected void executeTask(OnClickTask onClickTask) {

        SongsAsynckTask task = new SongsAsynckTask(onClickTask);
        task.execute();

    }

    protected void cancelTask(OnClickTask onClickTask) {

        SongsAsynckTask task = new SongsAsynckTask(onClickTask);

        if (task != null) {

            task.cancel(true);

        }

    }

    public class SongsAsynckTask extends AsyncTask<Void, Void, Void> {

        private OnClickTask onClickTask;

        public SongsAsynckTask(OnClickTask onClickTask) {

            this.onClickTask = onClickTask;

        }

        @Override
        protected Void doInBackground(Void... voids) {

            onClickTask.execute();
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {

            onClickTask.updateView();

        }

    }

}

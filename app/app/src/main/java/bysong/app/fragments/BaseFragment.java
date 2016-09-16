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
    public interface OnExecuteTask {

        void execute(Object parameters);
        void updateView(Object result);

    }

    protected void executeTask(OnExecuteTask onExecuteTask) {

        SongsAsynckTask task = new SongsAsynckTask(onExecuteTask);
        task.execute();

    }

    protected void cancelTask(OnExecuteTask onExecuteTask) {

        SongsAsynckTask task = new SongsAsynckTask(onExecuteTask);

        if (task != null) {

            task.cancel(true);

        }

    }

    public class SongsAsynckTask extends AsyncTask<Object, Void, Object> {

        private OnExecuteTask onExecuteTask;

        public SongsAsynckTask(OnExecuteTask onExecuteTask) {

            this.onExecuteTask = onExecuteTask;

        }

        @Override
        protected Void doInBackground(Object... voids) {

            onExecuteTask.execute(null);
            return null;

        }

        @Override
        protected void onPostExecute(Object result) {

            onExecuteTask.updateView(result);

        }

    }

}

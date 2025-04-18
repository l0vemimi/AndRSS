package com.andrss;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

public class AndRSSWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);

            // Set default text or loading indicator
            views.setTextViewText(R.id.rssTitle, "Loading RSS...");
            views.setTextViewText(R.id.rssDescription, "Please wait...");

            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
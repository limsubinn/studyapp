package com.example.orion.view.decorator;

import android.content.Context;
import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import androidx.core.content.ContextCompat;

import com.example.orion.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;

import java.util.Calendar;
import java.util.Date;

public class SelectDecorator implements DayViewDecorator {
    private CalendarDay date;
    private final Calendar calendar = Calendar.getInstance();

    Context context;

    public SelectDecorator(Date value, Context context) {
        date = CalendarDay.from(value);
        this.context = context;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        return day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setSelectionDrawable(ContextCompat.getDrawable(context, R.drawable.cal_select_decorator));

        if(date.getCalendar().get(Calendar.DAY_OF_WEEK)== Calendar.SATURDAY){
            view.addSpan(new ForegroundColorSpan(Color.BLUE));
        } else if(date.getCalendar().get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY){
            view.addSpan(new ForegroundColorSpan(Color.RED));
        } else {
            view.addSpan(new ForegroundColorSpan(Color.BLACK));
        }
    }
}



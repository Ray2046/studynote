package com.fatray.studynote.main.tools;

import androidx.annotation.IntDef;

import static com.fatray.studynote.main.tools.MainconstantTool.BEIJING;
import static com.fatray.studynote.main.tools.MainconstantTool.HANGZHOU;
import static com.fatray.studynote.main.tools.MainconstantTool.SHANGHAI;
import static com.fatray.studynote.main.tools.MainconstantTool.SHENZHEN;

@IntDef({SHANGHAI,HANGZHOU,BEIJING,SHENZHEN})
public @interface MainconstantTool {

    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;

}

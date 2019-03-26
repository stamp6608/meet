define({ "api": [
  {
    "type": "POST",
    "url": "http://url/user/info",
    "title": "1.4查询用户个人信息",
    "version": "1.0.0",
    "group": "1用户管理",
    "description": "<p>查询用户个人信息, 数字解析同1.3的参数定义，多选用&quot;,&quot;分割</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "telephone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": "<p>别名</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回成功",
          "content": "{\n\"code\":0,\n\"message:\"success\",\n\"data\":{\n\"code\" : 200,\n\"message\" : \"success\",\n\"data\" : {\n\"telephone\" : \"9847098888\",     //手机号\n\"language\" : \"English\",         //语种\n\"country\" : \"Philippines\",      //国家\n\"aliasName\" : \"marry\",          //别名\n\"birthday\" : \"10/5\",            //生日\n\"weight\" : \"55-70\",             //身高/体重\n\"sex\" : \"1\",                    //性别\n\"shape\" : \"2\",                  //体型\n\"race\" : \"3\",                   //种族\n\"emotion\" : \"3\",                //情感状况\n\"selfIntroduction\" : \"你好\",     //自我介绍\n\"expectType\" : \"1,2\",           //期待类型\n\"expectSex\" : \"1,2\",            //期待约会性别\n\"expectShape\" : \"1,3,4\",        //期待约会体型\n\"expectRace\" : \"2,3\",           //期待约会种族\n\"expectAge\" : \"30-50\",          //期待约会年龄\n\"city\" : \"Makaty\",              //城市\n\"hobby\" : \"2,4,5\",              //爱好\n\"religion\" : \"3\",               //宗教\n\"edutication\" : \"2\",            //教育\n\"smoke\" : \"1\",                  //吸烟/喝酒\n\"hasBaby\" : \"0\"                 //是否期待小孩\n}\n}\n}\n</b>\n加密此json对象后返回",
          "type": "Object"
        }
      ]
    },
    "filename": "./controller/UserController.java",
    "groupTitle": "1用户管理",
    "name": "PostHttpUrlUserInfo"
  },
  {
    "type": "POST",
    "url": "http://url/user/rUser",
    "title": "1.3用户信息注册",
    "version": "1.0.0",
    "group": "1用户管理",
    "description": "<p>用户信息注册，请在http的header中设置ip。 </b> 各选项用对应数字表示，多选请用&quot;,&quot;分割</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "telephone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "language",
            "description": "<p>语种</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "country",
            "description": "<p>国家</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "aliasName",
            "description": "<p>别名</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "birthday",
            "description": "<p>生日</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "weight",
            "description": "<p>身高/体重</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "sex",
            "description": "<p>性别 (MAN(&quot;男&quot;,&quot;1&quot;),WOMAN(&quot;女&quot;,&quot;2&quot;), OTHER(&quot;其他&quot;, &quot;0&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "city",
            "description": "<p>城市</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "shape",
            "description": "<p>体型 (BALANCE(&quot;匀称&quot;,&quot;1&quot;),NORMAL(&quot;一般&quot;,&quot;0&quot;), CONCERT(&quot;协调&quot;, &quot;2&quot;),FAT(&quot;胖&quot;,&quot;3&quot;),MUSCULAR(&quot;肌肉&quot;,&quot;4&quot;), THIN(&quot;瘦&quot;, &quot;5&quot;),STRONG(&quot;强壮&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "race",
            "description": "<p>种族 (OTHER(&quot;其它&quot;,&quot;0&quot;), ASIA(&quot;亚洲&quot;,&quot;1&quot;), AFRICA(&quot;非洲&quot;, &quot;2&quot;),LATIN(&quot;拉丁&quot;,&quot;3&quot;),MIDDLE(&quot;中东&quot;,&quot;4&quot;), MESTIZO(&quot;混血&quot;, &quot;5&quot;),AMERICA(&quot;美洲&quot;,&quot;6&quot;),SOURCE(&quot;南亚&quot;, &quot;5&quot;),EUROPE(&quot;欧洲&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "emotion",
            "description": "<p>情感状况 (SINGLE(&quot;单身&quot;,&quot;0&quot;), MARRIED(&quot;已婚&quot;,&quot;1&quot;), DISSOCIATON(&quot;离异&quot;, &quot;2&quot;),LOVE(&quot;恋爱中&quot;,&quot;3&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "selfIntroduction",
            "description": "<p>自我介绍</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "expectType",
            "description": "<p>期待类型 (NONE(&quot;无&quot;,&quot;0&quot;), CHAT(&quot;聊天&quot;,&quot;1&quot;), APPOINTMENT(&quot;约会&quot;, &quot;2&quot;),MAKE(&quot;交友&quot;,&quot;3&quot;), NETCHAT(&quot;网聊&quot;,&quot;4&quot;), FRIEND(&quot;朋友&quot;, &quot;5&quot;),HOOKUP(&quot;约炮&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "expectSex",
            "description": "<p>期待约会性别 (MAN(&quot;男&quot;,&quot;1&quot;), WOMAN(&quot;女&quot;,&quot;2&quot;), APPOINTMENT(&quot;其它&quot;, &quot;0&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "expectShape",
            "description": "<p>期待约会体型 ( BALANCE(&quot;匀称&quot;,&quot;1&quot;),NORMAL(&quot;一般&quot;,&quot;0&quot;), CONCERT(&quot;协调&quot;, &quot;2&quot;),FAT(&quot;胖&quot;,&quot;3&quot;),MUSCULAR(&quot;肌肉&quot;,&quot;4&quot;), THIN(&quot;瘦&quot;, &quot;5&quot;),STRONG(&quot;强壮&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "expectRace",
            "description": "<p>期待约会种族 (OTHER(&quot;其它&quot;,&quot;0&quot;), ASIA(&quot;亚洲&quot;,&quot;1&quot;), AFRICA(&quot;非洲&quot;, &quot;2&quot;),LATIN(&quot;拉丁&quot;,&quot;3&quot;),MIDDLE(&quot;中东&quot;,&quot;4&quot;), MESTIZO(&quot;混血&quot;, &quot;5&quot;),AMERICA(&quot;美洲&quot;,&quot;6&quot;),SOURCE(&quot;南亚&quot;, &quot;5&quot;),EUROPE(&quot;欧洲&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "expectAge",
            "description": "<p>期待约会年龄</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "hobby",
            "description": "<p>爱好 (NONE(&quot;无&quot;,&quot;0&quot;), MOVIE(&quot;电影&quot;,&quot;1&quot;), READ(&quot;读书&quot;, &quot;2&quot;),TV(&quot;电视&quot;,&quot;3&quot;), MUSIC(&quot;音乐&quot;,&quot;4&quot;),FAMILY(&quot;家庭&quot;, &quot;5&quot;),PET(&quot;宠物&quot;,&quot;6&quot;),DIRINK(&quot;喝酒&quot;, &quot;7&quot;), HOTEL(&quot;旅馆&quot;,&quot;8&quot;),SHOP(&quot;购物&quot;,&quot;9&quot;), PHYSICAL(&quot;看体育节目&quot;, &quot;10&quot;),SPROTS(&quot;运动&quot;,&quot;11&quot;),BAR(&quot;酒吧&quot;, &quot;12&quot;),DANCE(&quot;跳舞&quot;, &quot;13&quot;),GAME(&quot;游戏&quot;,&quot;14&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "religion",
            "description": "<p>宗教 (NONE(&quot;无&quot;,&quot;0&quot;), BUDDHIST(&quot;佛教&quot;,&quot;1&quot;), CHRISTIAN(&quot;基督教&quot;, &quot;2&quot;),CATHOLIC(&quot;天主教&quot;,&quot;3&quot;), SIKH(&quot;印度教&quot;,&quot;4&quot;),ISLAMITE(&quot;伊斯兰教&quot;, &quot;5&quot;),OTHERS(&quot;其他教派&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "edutication",
            "description": "<p>教育 (NONE(&quot;无&quot;,&quot;0&quot;), HIGHSCHOOL(&quot;高中&quot;,&quot;1&quot;), ACADEMIC(&quot;学院&quot;, &quot;2&quot;),COLLEAGE(&quot;本科&quot;,&quot;3&quot;), JUNIOR(&quot;专科&quot;,&quot;4&quot;),DOCTOR(&quot;博士&quot;, &quot;5&quot;),MASTER(&quot;硕士&quot;,&quot;6&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "smoke",
            "description": "<p>吸烟/喝酒 (NEVER(&quot;从不&quot;,&quot;1&quot;),SOMETIMES(&quot;偶尔&quot;,&quot;2&quot;), USUALLY(&quot;经常&quot;, &quot;3&quot;), NONE(&quot;无&quot;, &quot;0&quot;))</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "hasBaby",
            "description": "<p>是否期待小孩 (NONE(&quot;无&quot;,&quot;1&quot;),COHABIT(&quot;已育同住&quot;,&quot;2&quot;), SEPARATION(&quot;已育分居&quot;, &quot;0&quot;),NOBABY(&quot;无小孩&quot;,&quot;1&quot;), SINGLE(&quot;独身主义者&quot;,&quot;2&quot;))</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回成功",
          "content": "{\n\"code\":0,\n\"message:\"success\",\n\"data\":{}\n}\n</b>\n加密此json对象后返回",
          "type": "Object"
        }
      ]
    },
    "filename": "./controller/UserController.java",
    "groupTitle": "1用户管理",
    "name": "PostHttpUrlUserRuser"
  },
  {
    "type": "POST",
    "url": "http://url/user/vCode",
    "title": "1.2手机短信验证码验证",
    "version": "1.0.0",
    "group": "1用户管理",
    "description": "<p>手机短信验证码验证</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "telephone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "language",
            "description": "<p>语种</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "country",
            "description": "<p>国家</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "verifyCode",
            "description": "<p>短信验证码</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回成功",
          "content": "{\n\"code\":0,\n\"message:\"success\",\n\"data\":{}\n}\n</b>\n加密此json对象后返回",
          "type": "Object"
        }
      ]
    },
    "filename": "./controller/UserController.java",
    "groupTitle": "1用户管理",
    "name": "PostHttpUrlUserVcode"
  },
  {
    "type": "POST",
    "url": "http://url/user/verify",
    "title": "1.1获取手机短信验证 (需接入第三方手机短信验证平台)",
    "version": "1.0.0",
    "group": "1用户管理",
    "description": "<p>获取手机短信验证 (需接入第三方手机短信验证平台)</p>",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "telephone",
            "description": "<p>手机号</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "language",
            "description": "<p>语种</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "country",
            "description": "<p>国家</p>"
          }
        ]
      }
    },
    "success": {
      "examples": [
        {
          "title": "返回成功",
          "content": "{\n\"code\":0,\n\"message:\"success\",\n\"data\":{}\n}\n</b>\n加密此json对象后返回",
          "type": "Object"
        }
      ]
    },
    "filename": "./controller/UserController.java",
    "groupTitle": "1用户管理",
    "name": "PostHttpUrlUserVerify"
  },
  {
    "success": {
      "fields": {
        "Success 200": [
          {
            "group": "Success 200",
            "optional": false,
            "field": "varname1",
            "description": "<p>No type.</p>"
          },
          {
            "group": "Success 200",
            "type": "String",
            "optional": false,
            "field": "varname2",
            "description": "<p>With type.</p>"
          }
        ]
      }
    },
    "type": "",
    "url": "",
    "version": "0.0.0",
    "filename": "./apidoc/main.js",
    "group": "F:\\66666\\meet\\meet\\meet-web\\src\\main\\java\\com\\cn\\meet\\apidoc\\main.js",
    "groupTitle": "F:\\66666\\meet\\meet\\meet-web\\src\\main\\java\\com\\cn\\meet\\apidoc\\main.js",
    "name": ""
  }
] });
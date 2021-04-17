USE [newDB]
GO
/****** Object:  Table [dbo].[CONTACT]    Script Date: 02/04/2021 3:52:13 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CONTACT](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FIRSTNAME] [varchar](50) NULL,
	[LASTNAME] [varchar](50) NULL,
	[PHONENUMBER] [varchar](50) NULL,
	[ADDRESS] [varchar](50) NULL,
	[EMAIL] [varchar](50) NULL,
	[USERID] [int] NULL,
 CONSTRAINT [PK_CONTACT] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[USERS]    Script Date: 02/04/2021 3:52:13 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[USERS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USERNAME] [varchar](50) NULL,
	[PASSWORD] [varchar](50) NULL,
	[EMAIL] [varchar](50) NULL,
 CONSTRAINT [PK_USER] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[CONTACT] ON 

INSERT [dbo].[CONTACT] ([ID], [FIRSTNAME], [LASTNAME], [PHONENUMBER], [ADDRESS], [EMAIL], [USERID]) VALUES (1, N'huy', N'gia tong', N'0362529468', N'can tho', N'huytpgde1222@fpt.edu.vn', 2)
INSERT [dbo].[CONTACT] ([ID], [FIRSTNAME], [LASTNAME], [PHONENUMBER], [ADDRESS], [EMAIL], [USERID]) VALUES (3, N'long ', N'san', N'0362529422', N'hue', N'tpgiahuy55@gmail.com', 2)
INSERT [dbo].[CONTACT] ([ID], [FIRSTNAME], [LASTNAME], [PHONENUMBER], [ADDRESS], [EMAIL], [USERID]) VALUES (4, N'hoa', N'long', N'03625294223', N'da nang', N'tpgiahuy5@gmail.com', 2)
SET IDENTITY_INSERT [dbo].[CONTACT] OFF
SET IDENTITY_INSERT [dbo].[USERS] ON 

INSERT [dbo].[USERS] ([ID], [USERNAME], [PASSWORD], [EMAIL]) VALUES (1, N'admin', N'12345', N'tpgiahuy55@gmail.com')
INSERT [dbo].[USERS] ([ID], [USERNAME], [PASSWORD], [EMAIL]) VALUES (2, N'huyhue', N'123456', N'huytpgde140306@fpt.edu.vn')
SET IDENTITY_INSERT [dbo].[USERS] OFF

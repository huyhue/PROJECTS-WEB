USE [lab2]
GO
/****** Object:  Table [dbo].[tb_department]    Script Date: 11/04/2021 5:03:30 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_department](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[description] [varchar](255) NULL,
	[name] [varchar](255) NULL,
	[line_manager_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_employee]    Script Date: 11/04/2021 5:03:30 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_employee](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[age] [int] NULL,
	[birthday] [datetime] NULL,
	[dateCreated] [datetime] NULL,
	[description] [text] NULL,
	[disabled] [bit] NOT NULL,
	[endTime] [datetime] NULL,
	[name] [varchar](255) NULL,
	[salary] [float] NULL,
	[sex] [varchar](255) NULL,
	[startTime] [datetime] NULL,
	[department_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tb_department] ON 

INSERT [dbo].[tb_department] ([id], [description], [name], [line_manager_id]) VALUES (2, N'ok2', N'LanHP', 4)
INSERT [dbo].[tb_department] ([id], [description], [name], [line_manager_id]) VALUES (3, N'ok3', N'Tester', 2)
SET IDENTITY_INSERT [dbo].[tb_department] OFF
SET IDENTITY_INSERT [dbo].[tb_employee] ON 

INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (1, 21, CAST(N'1982-04-21T00:00:00.000' AS DateTime), CAST(N'2021-04-09T22:08:33.287' AS DateTime), N'099 Walter Keys', 0, CAST(N'1970-01-01T17:08:13.000' AS DateTime), N'Marcus', 2493.6565864688373, N'F', CAST(N'1970-01-01T07:08:13.000' AS DateTime), NULL)
INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (2, 42, CAST(N'1950-03-13T00:00:00.000' AS DateTime), CAST(N'2021-04-09T22:08:34.917' AS DateTime), N'5095 Hirthe Curve', 0, CAST(N'1970-01-01T17:07:21.000' AS DateTime), N'Melody', 2114.8747077950106, N'M', CAST(N'1970-01-01T08:07:21.000' AS DateTime), NULL)
INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (4, 21, CAST(N'1966-09-23T00:00:00.000' AS DateTime), CAST(N'2021-04-09T22:08:37.337' AS DateTime), N'27281 Youlanda Via', 0, CAST(N'1970-01-01T17:03:04.000' AS DateTime), N'Londa', 3686.8659798877188, N'F', CAST(N'1970-01-01T08:03:04.000' AS DateTime), NULL)
INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (5, 45, CAST(N'1989-04-20T00:00:00.000' AS DateTime), CAST(N'2021-04-09T22:08:38.590' AS DateTime), N'4371 Clarissa Lock', 0, CAST(N'1970-01-01T17:08:33.000' AS DateTime), N'Yen', 4644.3839777686317, N'M', CAST(N'1970-01-01T08:08:33.000' AS DateTime), NULL)
INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (6, 53, CAST(N'1964-10-08T00:00:00.000' AS DateTime), CAST(N'2021-04-10T16:13:13.733' AS DateTime), N'1698 Schimmel Skyway', 0, CAST(N'1970-01-01T16:16:48.000' AS DateTime), N'Wai', 1417.84, N'M', CAST(N'1970-01-01T08:16:48.000' AS DateTime), 3)
INSERT [dbo].[tb_employee] ([id], [age], [birthday], [dateCreated], [description], [disabled], [endTime], [name], [salary], [sex], [startTime], [department_id]) VALUES (7, 49, CAST(N'1957-11-01T00:00:00.000' AS DateTime), CAST(N'2021-04-10T16:13:15.917' AS DateTime), N'1494 Lanelle Plains', 0, CAST(N'1970-01-01T17:34:09.000' AS DateTime), N'Valentin', 4516.36, N'F', CAST(N'1970-01-01T07:34:09.000' AS DateTime), 3)
SET IDENTITY_INSERT [dbo].[tb_employee] OFF
ALTER TABLE [dbo].[tb_department]  WITH CHECK ADD  CONSTRAINT [FK_rd2cs00vhf9gs1x40nbsb8g9q] FOREIGN KEY([line_manager_id])
REFERENCES [dbo].[tb_employee] ([id])
GO
ALTER TABLE [dbo].[tb_department] CHECK CONSTRAINT [FK_rd2cs00vhf9gs1x40nbsb8g9q]
GO
ALTER TABLE [dbo].[tb_employee]  WITH CHECK ADD  CONSTRAINT [FK_ce0979mr9qjlv9x2co2l5y8pt] FOREIGN KEY([department_id])
REFERENCES [dbo].[tb_department] ([id])
GO
ALTER TABLE [dbo].[tb_employee] CHECK CONSTRAINT [FK_ce0979mr9qjlv9x2co2l5y8pt]
GO
